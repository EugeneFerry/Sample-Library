package com.sample.library.business.loan;

import com.sample.library.dal.dto.LoanDTO;

/**
 * The type Loan book param.
 */
public class LoanBookParam {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Loan. */
    private LoanDTO loan;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Loan book param.
     *
     * @param loan the loan
     */
    public LoanBookParam(final LoanDTO loan) {
        super();
        this.loan = loan;
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets loan.
     *
     * @return the loan
     */
    public LoanDTO getLoan() {
        return this.loan;
    }

    /**
     * Sets loan.
     *
     * @param loan the loan
     */
    public void setLoan(LoanDTO loan) {
        this.loan = loan;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("LoanBookParam [loan=%s]", this.loan);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
