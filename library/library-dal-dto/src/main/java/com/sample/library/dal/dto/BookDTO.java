package com.sample.library.dal.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * The type Book dto.
 */
@Entity
@Table(name="BOOK")
public class BookDTO implements Serializable {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant serialVersionUID. */
    private static final long serialVersionUID = 434657735728905317L;

    /** The Id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BK_ID", nullable = false)
    private Integer id;

    /** The Author. */
    @Column(name = "BK_AUTHOR", nullable = false)
    private String author;

    /** The Title. */
    @Column(name = "BK_TITLE", nullable = false, unique = true)
    private String title;

    /** The Categories. */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "BOOK_CATEGORY",
        joinColumns = {@JoinColumn(name = "BKCAT_BK_ID", referencedColumnName = "BK_ID")},
        inverseJoinColumns = {@JoinColumn(name = "BKCAT_CAT_ID", referencedColumnName = "CAT_ID")}
    )
    private List<CategoryDTO> categories;


    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Book dto.
     */
    public BookDTO() {
        super();
    }

    /**
     * Instantiates a new Book dto.
     *
     * @param id the id
     */
    public BookDTO(Integer id) {
        super();
        this.id = id;
    }

    /**
     * Instantiates a new Book dto.
     *
     * @param id the id
     * @param author the author
     * @param title the title
     * @param categories the categories
     */
    public BookDTO(Integer id, String author, String title, List<CategoryDTO> categories) {
        super();
        this.id = id;
        this.author = author;
        this.title = title;
        this.categories = categories;
    }

    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
    public List<CategoryDTO> getCategories() {
        return this.categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("BookDTO [id=%s, author=%s, title=%s, categories=%s]",
                this.id, this.author, this.title, this.categories);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
