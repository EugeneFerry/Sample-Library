package com.sample.library.business.loan;

import java.util.List;

import com.sample.library.dal.dto.LoanDTO;

/**
 * The type Find loans resp.
 */
public class FindLoansResp {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Loans. */
    private List<LoanDTO> loans;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Find loans resp.
     *
     * @param loans the loans
     */
    public FindLoansResp(final List<LoanDTO> loans) {
        super();
        this.loans = loans;
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets loans.
     *
     * @return the loans
     */
    public List<LoanDTO> getLoans() {
        return this.loans;
    }

    /**
     * Sets loans.
     *
     * @param loans the loans
     */
    public void setLoans(List<LoanDTO> loans) {
        this.loans = loans;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("FindLoansResp [loans=%s]", this.loans);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
