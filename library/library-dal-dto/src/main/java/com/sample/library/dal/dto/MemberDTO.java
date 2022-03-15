package com.sample.library.dal.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type Member dto.
 */
@Entity
@Table(name="MEMBER")
public class MemberDTO implements Serializable {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant serialVersionUID. */
    private static final long serialVersionUID = -725257379453422302L;

    /** The Id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEM_ID", nullable = false)
    private Integer id;

    /** The Name. */
    @Column(name = "MEM_NAME", nullable = false)
    private String name;

    /** The Email. */
    @Column(name = "MEM_EMAIL", nullable = false)
    private String email;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Member dto.
     */
    public MemberDTO() {
        super();
    }

    /**
     * Instantiates a new Member dto.
     *
     * @param id the id
     */
    public MemberDTO(Integer id) {
        super();
        this.id = id;
    }

    /**
     * Instantiates a new Member dto.
     *
     * @param id the id
     * @param name the name
     * @param email the email
     */
    public MemberDTO(Integer id, String name, String email) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
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
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("MemberDTO [id=%s, name=%s, email=%s]",
                this.id, this.name, this.email);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
