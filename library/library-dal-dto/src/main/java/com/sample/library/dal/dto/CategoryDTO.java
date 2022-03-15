package com.sample.library.dal.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type Category dto.
 */
@Entity
@Table(name="CATEGORY")
public class CategoryDTO implements Serializable {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant serialVersionUID. */
    private static final long serialVersionUID = 382135134874210725L;

    /** The Id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAT_ID", nullable = false)
    private Integer id;

    /** The Name. */
    @Column(name = "CAT_NAME", nullable = false, unique = true)
    private String name;


    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Category dto.
     */
    public CategoryDTO() {
        super();
    }

    /**
     * Instantiates a new Category dto.
     *
     * @param id the id
     * @param name the name
     */
    public CategoryDTO(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("CategoryDTO [id=%s, name=%s]",
                this.id, this.name);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
