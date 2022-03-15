package com.sample.library.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.library.dal.dto.CategoryDTO;

/**
 * The interface Category repository.
 */
public interface CategoryRepository extends JpaRepository<CategoryDTO, Integer> {
}
