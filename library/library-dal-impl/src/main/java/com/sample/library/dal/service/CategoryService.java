package com.sample.library.dal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.library.dal.dto.CategoryDTO;
import com.sample.library.dal.repository.CategoryRepository;

/**
 * The type Category service.
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class CategoryService implements ICategoryService {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Category repository. */
    private CategoryRepository categoryRepository;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Category service.
     */
    public CategoryService() {
        super();
    }

    /**
     * Instantiates a new Category service.
     *
     * @param categoryRepository the category repository
     */
    public CategoryService(final CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets category repository.
     *
     * @return the category repository
     */
    public CategoryRepository getCategoryRepository() {
        return this.categoryRepository;
    }

    /**
     * Sets category repository.
     *
     * @param categoryRepository the category repository
     */
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Save category dto.
     *
     * @param category the category
     * @return the category dto
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public CategoryDTO save(CategoryDTO category) {
        return getCategoryRepository().saveAndFlush(category);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<CategoryDTO> findById(int id) {
        return getCategoryRepository().findById(id);
    }

    /**
     * Find all list.
     *
     * @param category the category
     * @return the list
     */
    @Override
    public List<CategoryDTO> findAll(CategoryDTO category) {
        return getCategoryRepository().findAll();
    }

    /**
     * Delete.
     *
     * @param category the category
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(CategoryDTO category) {
        getCategoryRepository().delete(category);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
