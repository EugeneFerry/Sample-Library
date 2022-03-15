package com.sample.library.business.loan;

import static org.assertj.core.api.Assertions.*;

import com.sample.library.dal.dto.LoanDTO;
import org.junit.jupiter.api.Test;

/**
 * The type Loan book param test.
 */
class LoanBookParamTest {

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
        LoanDTO loan = new LoanDTO();
        LoanBookParam param = new LoanBookParam(null);
        param.setLoan(loan);
        assertThat(param.getLoan()).isEqualTo(loan);
    }


    /**
     * Test default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        LoanDTO loan = new LoanDTO();
        LoanBookParam param = new LoanBookParam(loan);
        assertThat(param.getLoan()).isEqualTo(loan);
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        String expectedString = "LoanBookParam [loan=null]";
        assertThat(new LoanBookParam(null).toString()).isEqualTo(expectedString);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}