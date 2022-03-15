package com.sample.library.business.loan;

import static com.sample.library.dal.type.CategoryType.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.anyInt;
import static org.mockito.BDDMockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.web.server.ResponseStatusException;

import com.sample.library.dal.dto.BookDTO;
import com.sample.library.dal.dto.CategoryDTO;
import com.sample.library.dal.dto.LoanDTO;
import com.sample.library.dal.dto.MemberDTO;
import com.sample.library.dal.service.ILoanService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * The type Loan book command test.
 */
@ExtendWith(MockitoExtension.class)
class LoanBookCommandTest {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant MAX_LOANS_EXCEEDED. */
    private static final String MAX_LOANS_EXCEEDED = "500 INTERNAL_SERVER_ERROR \"Max loans exceeded\"";

    /** The constant OVERDUE_LOANS_EXISTS. */
    private static final String OVERDUE_LOANS_EXISTS = "500 INTERNAL_SERVER_ERROR \"Overdue loans exists\"";

    /** The constant BOOK_NOT_AVAILABLE. */
    private static final String BOOK_NOT_AVAILABLE = "404 NOT_FOUND \"Book not available\"";

    /** The Loan service. */
    @Mock
    private ILoanService loanService;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets constructor.
     */
    @Test
    void getConstructor() {
        LoanBookCommand command = new LoanBookCommand(loanService, 3);
        assertThat(command.getLoanService()).isSameAs(loanService);
        assertThat(command.getMaxLoans()).isEqualTo(3);
    }

    /**
     * Execute.
     */
    @Test
    void execute() {

        /*
         * Given
         */
        LoanDTO loan = loan();
        given(loanService.countByMemberId(anyInt())).willReturn(2l);
        given(loanService.countByMemberIdAndExpireDate(anyInt(), any(LocalDate.class))).willReturn(0l);
        given(loanService.findByBookId(anyInt())).willReturn(Optional.empty());
        given(loanService.save(any(LoanDTO.class))).willReturn(loan);

        /*
         * When
         */
        LoanBookCommand command = new LoanBookCommand(loanService, 3);
        LoanBookResp resp = command.execute(new LoanBookParam(loan));

        /*
         * Then
         */
        verify(loanService, times(1)).countByMemberId(anyInt());
        verify(loanService, times(1)).countByMemberIdAndExpireDate(anyInt(), any(LocalDate.class));
        verify(loanService, times(1)).findByBookId(anyInt());
        verify(loanService, times(1)).save(any(LoanDTO.class));
        assertThat(resp.getLoan()).isEqualTo(loan);
    }

    /**
     * Execute failure max loans exceeded.
     */
    @Test
    void executeFailureMaxLoansExceeded() {

        /*
         * Given
         */
        LoanDTO loan = loan();
        given(loanService.countByMemberId(anyInt())).willReturn(3l);

        /*
         * When
         */
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            new LoanBookCommand(loanService, 3).execute(new LoanBookParam(loan));
        });

        /*
         * Then
         */
        assertThat(exception.getMessage()).isEqualTo(MAX_LOANS_EXCEEDED);
        verify(loanService, times(1)).countByMemberId(anyInt());
    }

    /**
     * Execute failure overdue loan exists.
     */
    @Test
    void executeFailureOverdueLoanExists() {

        /*
         * Given
         */
        LoanDTO loan = loan();
        given(loanService.countByMemberId(anyInt())).willReturn(2l);
        given(loanService.countByMemberIdAndExpireDate(anyInt(), any(LocalDate.class))).willReturn(1l);

        /*
         * When
         */
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            new LoanBookCommand(loanService, 3).execute(new LoanBookParam(loan));
        });

        /*
         * Then
         */
        assertThat(exception.getMessage()).isEqualTo(OVERDUE_LOANS_EXISTS);
        verify(loanService, times(1)).countByMemberId(anyInt());
    }

    /**
     * Execute failure book not available.
     */
    @Test
    void executeFailureBookNotAvailable() {

        /*
         * Given
         */
        LoanDTO loan = loan();
        given(loanService.countByMemberId(anyInt())).willReturn(2l);
        given(loanService.countByMemberIdAndExpireDate(anyInt(), any(LocalDate.class))).willReturn(0l);
        given(loanService.findByBookId(anyInt())).willReturn(Optional.of(new LoanDTO()));

        /*
         * When
         */
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            new LoanBookCommand(loanService, 3).execute(new LoanBookParam(loan));
        });

        /*
         * Then
         */
        assertThat(exception.getMessage()).isEqualTo(BOOK_NOT_AVAILABLE);
        verify(loanService, times(1)).countByMemberId(anyInt());
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

    /**
     * Loan loan dto.
     *
     * @return the loan dto
     */
    private LoanDTO loan() {
        LocalDate date = LocalDate.now();
        List<CategoryDTO> categories = Lists.newArrayList(new CategoryDTO(ACTION_ADVENTURE.getId(), ACTION_ADVENTURE.getName()));
        BookDTO book = new BookDTO(1, "author", "title", categories);
        MemberDTO member = new MemberDTO(1, "name", "email");
        return new LoanDTO(1, book, member, date, date);
    }

}