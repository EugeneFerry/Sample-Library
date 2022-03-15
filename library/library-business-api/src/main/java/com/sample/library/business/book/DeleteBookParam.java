package com.sample.library.business.book;

/**
 * The type Delete book param.
 */
public class DeleteBookParam {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Book id. */
    private int bookId;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Delete book param.
     *
     * @param bookId the book id
     */
    public DeleteBookParam(final int bookId) {
        super();
        this.bookId = bookId;
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
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("DeleteBookParam [bookId=%s]", this.bookId);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
