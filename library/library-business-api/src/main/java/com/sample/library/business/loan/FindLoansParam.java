package com.sample.library.business.loan;

/**
 * The type Find loans param.
 */
public class FindLoansParam {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Member id. */
    private int memberId;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Find loans param.
     *
     * @param memberId the member id
     */
    public FindLoansParam(final int memberId) {
        super();
        this.memberId = memberId;
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets member id.
     *
     * @return the member id
     */
    public int getMemberId() {
        return this.memberId;
    }

    /**
     * Sets member id.
     *
     * @param memberId the member id
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("FindLoansParam [memberId=%s]", this.memberId);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
