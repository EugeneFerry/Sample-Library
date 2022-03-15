package com.sample.library.dal.dto;

import static com.sample.library.dal.type.CategoryType.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

/**
 * The type Book dto test.
 */
class BookDTOTest {

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
        List<CategoryDTO> categories = Lists.newArrayList(new CategoryDTO(ACTION_ADVENTURE.getId(), ACTION_ADVENTURE.getName()));
        BookDTO book = new BookDTO();
        book.setId(1);
        book.setAuthor("author");
        book.setTitle("title");
        book.setCategories(categories);
        assertThat(book.getId()).isEqualTo(1);
        assertThat(book.getAuthor()).isEqualTo("author");
        assertThat(book.getTitle()).isEqualTo("title");
        assertThat(book.getCategories()).isEqualTo(categories);
    }


    /**
     * Test default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        BookDTO book = new BookDTO();
        assertThat(book.getId()).isNull();
        assertThat(book.getAuthor()).isNull();
        assertThat(book.getTitle()).isNull();
        assertThat(book.getCategories()).isNull();
    }

    /**
     * Test constructor 1.
     */
    @Test
    public void testConstructor1() {
        BookDTO book = new BookDTO(1);
        assertThat(book.getId()).isEqualTo(1);
        assertThat(book.getAuthor()).isNull();
        assertThat(book.getTitle()).isNull();
        assertThat(book.getCategories()).isNull();
    }

    /**
     * Test constructor 2.
     */
    @Test
    public void testConstructor2() {
        List<CategoryDTO> categories = Lists.newArrayList(new CategoryDTO(ACTION_ADVENTURE.getId(), ACTION_ADVENTURE.getName()));
        BookDTO book = new BookDTO(1, "author", "title", categories);
        assertThat(book.getId()).isEqualTo(1);
        assertThat(book.getAuthor()).isEqualTo("author");
        assertThat(book.getTitle()).isEqualTo("title");
        assertThat(book.getCategories()).isEqualTo(categories);
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        String expectedString = "BookDTO [id=null, author=null, title=null, categories=null]";
        assertThat(new BookDTO().toString()).isEqualTo(expectedString);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}