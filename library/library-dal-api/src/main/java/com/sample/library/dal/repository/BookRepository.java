package com.sample.library.dal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sample.library.dal.dto.BookDTO;
import com.sample.library.dal.dto.CategoryDTO;

/**
 * The interface Book repository.
 */
public interface BookRepository extends JpaRepository<BookDTO, Integer> {

    /**
     * Find by categories optional.
     *
     * @param category the category
     * @return the optional
     */
    Optional<List<BookDTO>> findByCategories(@Param("categories") final CategoryDTO category);

}
