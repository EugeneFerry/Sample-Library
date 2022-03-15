package com.sample.library.dal.dto;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/**
 * The type Loan dto test.
 */
class LoanDTOTest {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

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
     * Test getters and setters.
     */
    @Test
    public void testGettersAndSetters() {
        LocalDate date = LocalDate.now();
        BookDTO book = new BookDTO(1);
        MemberDTO member = new MemberDTO(1);
        LoanDTO loan = new LoanDTO();
        loan.setId(1);
        loan.setBook(book);
        loan.setMember(member);
        loan.setIssueDate(date);
        loan.setExpireDate(date);

        assertThat(loan.getId()).isEqualTo(1);
        assertThat(loan.getBook()).isEqualTo(book);
        assertThat(loan.getMember()).isEqualTo(member);
        assertThat(loan.getIssueDate()).isEqualTo(date);
        assertThat(loan.getExpireDate()).isEqualTo(date);
    }


    /**
     * Test default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        LoanDTO loan = new LoanDTO();
        assertThat(loan.getId()).isNull();
        assertThat(loan.getBook()).isNull();
        assertThat(loan.getMember()).isNull();
        assertThat(loan.getIssueDate()).isNull();
        assertThat(loan.getExpireDate()).isNull();
    }

    /**
     * Test constructor 1.
     */
    @Test
    public void testConstructor1() {
        LocalDate date = LocalDate.now();
        BookDTO book = new BookDTO(1);
        MemberDTO member = new MemberDTO(1);
        LoanDTO loan = new LoanDTO(1, book, member, date, date);
        assertThat(loan.getId()).isEqualTo(1);
        assertThat(loan.getBook()).isEqualTo(book);
        assertThat(loan.getMember()).isEqualTo(member);
        assertThat(loan.getIssueDate()).isEqualTo(date);
        assertThat(loan.getExpireDate()).isEqualTo(date);
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        String expectedString = "LoanDTO [id=null, book=null, member=null, issueDate=null, expireDate=null]";
        assertThat(new LoanDTO().toString()).isEqualTo(expectedString);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}