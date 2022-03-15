package com.sample.library.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * The type Loan request.
 */
public class LoanRequest {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Book id. */
    @NotNull
    @Positive
    private Integer bookId;

    /** The Member id. */
    @NotNull
    @Positive
    private Integer memberId;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Loan request.
     */
    public LoanRequest() {
        super();
    }

    /**
     * Instantiates a new Loan request.
     *
     * @param bookId the book id
     * @param memberId the member id
     */
    public LoanRequest(final Integer bookId, final Integer memberId) {
        super();
        this.bookId = bookId;
        this.memberId = memberId;
    }

    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets book id.
     *
     * @return the book id
     */
    public int getBookId() {
        return this.bookId;
    }

    /**
     * Sets book id.
     *
     * @param bookId the book id
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

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
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("LoanRequest [bookId=%s, memberId=%s]",
                this.bookId, this.memberId);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
