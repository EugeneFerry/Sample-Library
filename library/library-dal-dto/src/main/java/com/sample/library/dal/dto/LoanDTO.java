package com.sample.library.dal.dto;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The type Loan dto.
 */
@Entity
@Table(name="LOAN")
public class LoanDTO implements Serializable {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant serialVersionUID. */
    private static final long serialVersionUID = -7028458921711391884L;

    /** The Id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LN_ID", nullable = false)
    private Integer id;

    /** The Book. */
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "LN_BK_ID", referencedColumnName = "BK_ID")
    private BookDTO book;

    /** The Member. */
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "LN_MEM_ID", referencedColumnName = "MEM_ID")
    private MemberDTO member;

    /** The Issue date. */
    @Column(name = "LN_ISSUE_DATE", nullable = false)
    private LocalDate issueDate;

    /** The Expire date. */
    @Column(name = "LN_EXPIRE_DATE", nullable = false)
    private LocalDate expireDate;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Loan dto.
     */
    public LoanDTO() {
        super();
    }

    /**
     * Instantiates a new Loan dto.
     *
     * @param id the id
     * @param book the book
     * @param member the member
     * @param issueDate the issue date
     * @param expireDate the expire date
     */
    public LoanDTO(Integer id, BookDTO book, MemberDTO member, LocalDate issueDate, LocalDate expireDate) {
        super();
        this.id = id;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
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
     * Gets book.
     *
     * @return the book
     */
    public BookDTO getBook() {
        return this.book;
    }

    /**
     * Sets book.
     *
     * @param book the book
     */
    public void setBook(BookDTO book) {
        this.book = book;
    }

    /**
     * Gets member.
     *
     * @return the member
     */
    public MemberDTO getMember() {
        return this.member;
    }

    /**
     * Sets member.
     *
     * @param member the member
     */
    public void setMember(MemberDTO member) {
        this.member = member;
    }

    /**
     * Gets issue date.
     *
     * @return the issue date
     */
    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    /**
     * Sets issue date.
     *
     * @param issueDate the issue date
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * Gets expire date.
     *
     * @return the expire date
     */
    public LocalDate getExpireDate() {
        return this.expireDate;
    }

    /**
     * Sets expire date.
     *
     * @param expireDate the expire date
     */
    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("LoanDTO [id=%s, book=%s, member=%s, issueDate=%s, expireDate=%s]",
                this.id, this.book, this.member, this.issueDate, this.expireDate);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
