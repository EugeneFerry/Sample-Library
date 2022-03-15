package com.sample.library.business.book;

import java.util.List;

import com.sample.library.dal.dto.BookDTO;

/**
 * The type Find all books resp.
 */
public class FindAllBooksResp {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Books. */
    private List<BookDTO> books;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Find all books resp.
     *
     * @param books the books
     */
    public FindAllBooksResp(final List<BookDTO> books) {
        super();
        this.books = books;
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets books.
     *
     * @return the books
     */
    public List<BookDTO> getBooks() {
        return this.books;
    }

    /**
     * Sets books.
     *
     * @param books the books
     */
    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("FindAllBooksResp [books=%s]", this.books);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
