package com.sample.library.request;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sample.library.dal.type.CategoryType;

/**
 * The type Book request.
 */
public class BookRequest {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Author. */
    @NotNull
    @Size(max = 100, message = "Author should have a maximum of 100 characters")
    private String author;

    /** The Title. */
    @NotNull
    @Size(max = 150, message = "Title should have a maximum of 150 characters")
    private String title;

    /** The Categories. */
    @NotNull
    @NotEmpty
    private List<CategoryType> categories;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Book request.
     */
    public BookRequest() {
        super();
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
    public List<CategoryType> getCategories() {
        return this.categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(List<CategoryType> categories) {
        this.categories = categories;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("BookRequest [Author=%s, title=%s, categories=%s]",
                this.author, this.title, this.categories);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
