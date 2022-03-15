package com.sample.library.dal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.library.dal.dto.BookDTO;
import com.sample.library.dal.dto.CategoryDTO;
import com.sample.library.dal.repository.BookRepository;

/**
 * The type Book service.
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class BookService implements IBookService {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Book repository. */
    private BookRepository bookRepository;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Book service.
     */
    public BookService() {
        super();
    }

    /**
     * Instantiates a new Book service.
     *
     * @param bookRepository the book repository
     */
    public BookService(final BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    // ===========================================
    // Public Methods
    // ===========================================


    /**
     * Gets book repository.
     *
     * @return the book repository
     */
    public BookRepository getBookRepository() {
        return this.bookRepository;
    }

    /**
     * Save book dto.
     *
     * @param book the book
     * @return the book dto
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public BookDTO save(BookDTO book) {
        return getBookRepository().saveAndFlush(book);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<BookDTO> findById(int id) {
        return getBookRepository().findById(id);
    }


    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<BookDTO> findAll() {
        return getBookRepository().findAll();
    }

    /**
     * Find by category id optional.
     *
     * @param category the category
     * @return the optional
     */
    @Override
    public Optional<List<BookDTO>> findByCategoryId(CategoryDTO category) {
        return getBookRepository().findByCategories(category);
//        return Optional.empty();
    }

    /**
     * Delete.
     *
     * @param bookId the book id
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(int bookId) {
        getBookRepository().deleteById(bookId);
    }


    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
