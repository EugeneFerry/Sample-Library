package com.sample.library.dal.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * The type Category dto test.
 */
class CategoryDTOTest {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Test getters and setters.
     */
    @Test
    public void testGettersAndSetters() {
        CategoryDTO category = new CategoryDTO();
        category.setId(1);
        category.setName("Action");
        assertThat(category.getId()).isEqualTo(1);
        assertThat(category.getName()).isEqualTo("Action");
    }


    /**
     * Test default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        CategoryDTO category = new CategoryDTO();
        assertThat(category.getId()).isNull();
        assertThat(category.getName()).isNull();
    }

    /**
     * Test constructor 1.
     */
    @Test
    public void testConstructor1() {
        CategoryDTO category = new CategoryDTO(1, "Action");
        assertThat(category.getId()).isEqualTo(1);
        assertThat(category.getName()).isEqualTo("Action");
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        String expectedString = "CategoryDTO [id=null, name=null]";
        assertThat(new CategoryDTO().toString()).isEqualTo(expectedString);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}