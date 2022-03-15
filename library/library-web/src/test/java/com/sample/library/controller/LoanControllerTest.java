package com.sample.library.controller;

import static com.sample.library.dal.type.CategoryType.*;
import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sample.library.dal.dto.BookDTO;
import com.sample.library.dal.dto.CategoryDTO;
import com.sample.library.dal.dto.LoanDTO;
import com.sample.library.dal.dto.MemberDTO;
import com.sample.library.dal.repository.BookRepository;
import com.sample.library.dal.repository.CategoryRepository;
import com.sample.library.dal.repository.MemberRepository;
import com.sample.library.dal.service.ILoanService;
import com.sample.library.request.LoanRequest;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * The type Loan controller test.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@Transactional
class LoanControllerTest {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Web application context. */
    @Autowired
    private WebApplicationContext webApplicationContext;

    /** The Loan service. */
    @Autowired
    private ILoanService loanService;

    /** The Member repository. */
    @Autowired
    private MemberRepository memberRepository;

    /** The Book repository. */
    @Autowired
    private BookRepository bookRepository;

    /** The Category repository. */
    @Autowired
    private CategoryRepository categoryRepository;

    /** The Mock mvc. */
    private MockMvc mockMvc;

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
     */
    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.webApplicationContext)
                .build();

        createDefaultRecords();
    }

    /**
     * Test loan book.
     *
     * @throws Exception the exception
     */
    @Test
    void testLoanBook() throws Exception {

        LoanRequest request = new LoanRequest(1, 1);
        String requestBody = asJsonString(request);

        Optional<List<LoanDTO>> loans = loanService.findByMemberId(1);
        assertThat(loans.get()).isEmpty();

        this.mockMvc.perform(post("/api/loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated());

        loans = loanService.findByMemberId(1);
        assertThat(loans.get()).isNotEmpty();
    }

    /**
     * Test loan book max loan exceeded.
     *
     * @throws Exception the exception
     */
    @Test
    void testLoanBookMaxLoanExceeded() throws Exception {

        LoanDTO loan1 = createLoanRecord(1, 1);
        LoanDTO loan2 = createLoanRecord(2, 1);
        LoanDTO loan3 = createLoanRecord(3, 1);

        LoanRequest request = new LoanRequest(4, 1);
        String requestBody = asJsonString(request);

        this.mockMvc.perform(post("/api/loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isInternalServerError());
    }

    /**
     * Test loan book over due loan.
     *
     * @throws Exception the exception
     */
    @Test
    void testLoanBookOverDueLoan() throws Exception {

        LoanDTO loan1 = createOverdueLoanRecord(1, 1);

        LoanRequest request = new LoanRequest(4, 1);
        String requestBody = asJsonString(request);

        this.mockMvc.perform(post("/api/loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isInternalServerError());
    }

    /**
     * Test loan book not available.
     *
     * @throws Exception the exception
     */
    @Test
    void testLoanBookNotAvailable() throws Exception {

        LoanDTO loan1 = createLoanRecord(1, 2);

        LoanRequest request = new LoanRequest(1, 1);
        String requestBody = asJsonString(request);

        this.mockMvc.perform(post("/api/loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isNotFound());
    }

    /**
     * Test return book.
     *
     * @throws Exception the exception
     */
    @Test
    void testReturnBook() throws Exception {

        LoanDTO loan = createLoanRecord(1, 1);

        Optional<List<LoanDTO>> loans = loanService.findByMemberId(1);
        assertThat(loans.get()).isNotEmpty();

        this.mockMvc.perform(delete("/api/loans/" + loan.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        loans = loanService.findByMemberId(1);
        assertThat(loans.get()).isEmpty();
    }

    /**
     * Test get by member id.
     *
     * @throws Exception the exception
     */
    @Test
    void testGetByMemberId() throws Exception {
        LoanDTO loan = createLoanRecord(1, 1);

        MvcResult result = this.mockMvc.perform(get("/api/loans/member/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo(asJsonString(Lists.newArrayList(loan)));
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

    /**
     * Create loan record loan dto.
     *
     * @param bookId the book id
     * @param memberId the member id
     * @return the loan dto
     */
    private LoanDTO createLoanRecord(int bookId, int memberId) {
        LocalDate date = LocalDate.now();
        List<CategoryDTO> categories = Lists.newArrayList(new CategoryDTO(ACTION_ADVENTURE.getId(), ACTION_ADVENTURE.getName()));
        BookDTO book = new BookDTO(bookId, "author", "title", categories);
        MemberDTO member = new MemberDTO(memberId, "name", "email");
        return loanService.save(new LoanDTO(null, book, member, date, date.plusDays(7)));
    }

    /**
     * Create overdue loan record loan dto.
     *
     * @param bookId the book id
     * @param memberId the member id
     * @return the loan dto
     */
    private LoanDTO createOverdueLoanRecord(int bookId, int memberId) {
        LocalDate date = LocalDate.now();
        List<CategoryDTO> categories = Lists.newArrayList(new CategoryDTO(ACTION_ADVENTURE.getId(), ACTION_ADVENTURE.getName()));
        BookDTO book = new BookDTO(bookId, "author", "title", categories);
        MemberDTO member = new MemberDTO(memberId, "name", "email");
        return loanService.save(new LoanDTO(null, book, member, date.minusDays(7), date.minusDays(5)));
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

    /**
     * As json string string.
     *
     * @param obj the obj
     * @return the string
     */
    private static String asJsonString(final Object obj) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy,MM,dd");
            return new ObjectMapper().registerModule(new JavaTimeModule()).setDateFormat(df).writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}