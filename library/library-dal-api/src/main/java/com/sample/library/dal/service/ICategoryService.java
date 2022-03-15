package com.sample.library.dal.service;

import java.util.List;
import java.util.Optional;

import com.sample.library.dal.dto.CategoryDTO;

/**
 * The interface Category service.
 */
public interface ICategoryService {

    // ===========================================
    // Constants
    // ===========================================

    // ===========================================
    // Methods
    // ===========================================

    /**
     * Save category dto.
     *
     * @param category the category
     * @return the category dto
     */
    CategoryDTO save(final CategoryDTO category);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<CategoryDTO> findById(final int id);

    /**
     * Find all list.
     *
     * @param category the category
     * @return the list
     */
    List<CategoryDTO> findAll(final CategoryDTO category);

    /**
     * Delete.
     *
     * @param category the category
     */
    void delete(final CategoryDTO category);

}
