package com.sample.library.dal.service;

import java.util.List;
import java.util.Optional;

import com.sample.library.dal.dto.BookDTO;
import com.sample.library.dal.dto.CategoryDTO;

/**
 * The interface Book service.
 */
public interface IBookService {

    // ===========================================
    // Constants
    // ===========================================

    // ===========================================
    // Methods
    // ===========================================

    /**
     * Save book dto.
     *
     * @param book the book
     * @return the book dto
     */
    BookDTO save(final BookDTO book);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<BookDTO> findById(final int id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<BookDTO> findAll();

    /**
     * Find by category id optional.
     *
     * @param category the category
     * @return the optional
     */
    Optional<List<BookDTO>> findByCategoryId(final CategoryDTO category);

    /**
     * Delete.
     *
     * @param bookId the book id
     */
    void delete(final int bookId);
}
