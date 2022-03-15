package com.sample.library.dal.service;

import static com.sample.library.dal.type.CategoryType.*;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.sample.library.dal.config.TestDALConfig;
import com.sample.library.dal.dto.BookDTO;
import com.sample.library.dal.dto.CategoryDTO;
import com.sample.library.dal.dto.LoanDTO;
import com.sample.library.dal.dto.MemberDTO;
import com.sample.library.dal.repository.BookRepository;
import com.sample.library.dal.repository.CategoryRepository;
import com.sample.library.dal.repository.LoanRepository;
import com.sample.library.dal.repository.MemberRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * The type Loan service test.
 */
@DataJpaTest
@AutoConfigureTestDatabase
@ContextConfiguration(classes = TestDALConfig.class)
@EntityScan(basePackageClasses = LoanDTO.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LoanServiceTest {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Loan service. */
    @Autowired
    private ILoanService loanService;

    /** The Member repository. */
    @Autowired
    private MemberRepository memberRepository;

    /** The Book repository. */
    @Autowired
    private BookRepository bookRepository;

    /** The Loan repository. */
    @Autowired
    private LoanRepository loanRepository;

    /** The Category repository. */
    @Autowired
    private CategoryRepository categoryRepository;

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
     * Sets up.
     *
     * @throws Exception the exception
     */
    @BeforeAll
    public void setUp() throws Exception {
        createDefaultRecords();
    }


    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @AfterAll
    public void tearDown() throws Exception {
        loanRepository.deleteAll();
        bookRepository.deleteAll();
        categoryRepository.deleteAll();
        memberRepository.deleteAll();
    }


    /**
     * Test find by id.
     */
    @Test
    public void testFindById() {
        LoanDTO expectedLoan = loan(1, 1);

        Optional<LoanDTO> actualLoan = loanService.findById(expectedLoan.getId());

        assertThat(actualLoan).isNotNull();
        assertThat(actualLoan.get()).usingRecursiveComparison().isEqualTo(expectedLoan);
    }

    /**
     * Test find by member id.
     */
    @Test
    public void testFindByMemberId() {
        LoanDTO loan1 = loan(1, 1);
        LoanDTO loan2 = loan(2, 2);
        LoanDTO loan3 = loan(3, 1);

        Optional<List<LoanDTO>> loans = loanService.findByMemberId(1);

        assertThat(loans).isNotNull();
        assertThat(loans.get()).usingRecursiveComparison().isEqualTo(Lists.newArrayList(loan1, loan3));
    }

    /**
     * Test find by book id.
     */
    @Test
    public void testFindByBookId() {
        LoanDTO loan1 = loan(1, 1);
        LoanDTO loan2 = loan(2, 2);
        LoanDTO loan3 = loan(3, 1);

        Optional<LoanDTO> actualLoan = loanService.findByBookId(2);

        assertThat(actualLoan).isNotNull();
        assertThat(actualLoan.get()).usingRecursiveComparison().isEqualTo(loan2);
    }

    /**
     * Test find count by member id.
     */
    @Test
    public void testFindCountByMemberId() {
        LoanDTO loan1 = loan(1, 1);
        LoanDTO loan2 = loan(2, 2);
        LoanDTO loan3 = loan(3, 1);

        long expected = 2L;

        long actual = loanService.countByMemberId(1);

        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Test find count by member id and expire data.
     */
    @Test
    public void testFindCountByMemberIdAndExpireData() {
        LoanDTO loan1 = loan(1, 1);
        LoanDTO loan2 = loan(2, 2);
        LoanDTO loan3 = loan(3, 1);

        LocalDate date = LocalDate.now().plusDays(8);
        long expected = 2L;

        long actual = loanService.countByMemberIdAndExpireDate(1, date);

        assertThat(actual).isEqualTo(expected);
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
     * @param bookId the book id
     * @param memberId the member id
     * @return the loan dto
     */
    private LoanDTO loan(int bookId, int memberId) {
        LocalDate date = LocalDate.now();
        List<CategoryDTO> categories = Lists.newArrayList(new CategoryDTO(ACTION_ADVENTURE.getId(), ACTION_ADVENTURE.getName()));
        BookDTO book = new BookDTO(bookId, "author", "title", categories);
        MemberDTO member = new MemberDTO(memberId, "name", "email");
        return loanService.save(new LoanDTO(null, book, member, date, date.plusDays(7)));
    }

    /**
     * Create default records.
     */
    private void createDefaultRecords() {
        MemberDTO user1 = new MemberDTO(1, "User1", "user@email.com");
        MemberDTO user2 = new MemberDTO(2, "User2", "user@email.com");
        MemberDTO user3 = new MemberDTO(3, "User3", "user@email.com");

        CategoryDTO cat1 = new CategoryDTO(ACTION_ADVENTURE.getId(), ACTION_ADVENTURE.getName());
        CategoryDTO cat2 = new CategoryDTO(THRILLER.getId(), THRILLER.getName());
        CategoryDTO cat3 = new CategoryDTO(HORROR.getId(), HORROR.getName());
        CategoryDTO cat4 = new CategoryDTO(ROMANCE.getId(), ROMANCE.getName());

        BookDTO book1 = new BookDTO(1, "author1", "title1", Lists.newArrayList(cat1));
        BookDTO book2 = new BookDTO(2, "author2", "title2", Lists.newArrayList(cat2));
        BookDTO book3 = new BookDTO(3, "author3", "title3", Lists.newArrayList(cat3));
        BookDTO book4 = new BookDTO(4, "author4", "title4", Lists.newArrayList(cat4));

        memberRepository.save(user1);
        memberRepository.save(user2);
        memberRepository.save(user3);

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
        categoryRepository.save(cat3);
        categoryRepository.save(cat4);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
    }

}