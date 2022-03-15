package com.sample.library.business.book;

import com.sample.library.dal.dto.BookDTO;

/**
 * The type Add book resp.
 */
public class AddBookResp {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Book. */
    private BookDTO book;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Add book resp.
     *
     * @param book the book
     */
    public AddBookResp(final BookDTO book) {
        super();
        this.book = book;
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets book.
     *
     * @return the book
     */
    public BookDTO getBook() {
        return this.book;
    }

    /**
     * Sets book.
     *
     * @param book the book
     */
    public void setBook(BookDTO book) {
        this.book = book;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("AddBookResp [book=%s]", this.book);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
