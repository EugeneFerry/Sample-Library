package com.sample.library.dal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.library.dal.dto.LoanDTO;
import com.sample.library.dal.repository.LoanRepository;

/**
 * The type Loan service.
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class LoanService implements ILoanService {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Loan repository. */
    private LoanRepository loanRepository;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Loan service.
     */
    public LoanService() {
        super();
    }

    /**
     * Instantiates a new Loan service.
     *
     * @param loanRepository the loan repository
     */
    public LoanService(final LoanRepository loanRepository) {
        super();
        this.loanRepository = loanRepository;
    }

    // ===========================================
    // Public Methods
    // ===========================================


    /**
     * Gets loan repository.
     *
     * @return the loan repository
     */
    public LoanRepository getLoanRepository() {
        return this.loanRepository;
    }

    /**
     * Sets loan repository.
     *
     * @param loanRepository the loan repository
     */
    public void setLoanRepository(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    /**
     * Save loan dto.
     *
     * @param loan the loan
     * @return the loan dto
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public LoanDTO save(LoanDTO loan) {
        return getLoanRepository().saveAndFlush(loan);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<LoanDTO> findById(int id) {
        return getLoanRepository().findById(id);
    }

    /**
     * Find by book id optional.
     *
     * @param bookId the book id
     * @return the optional
     */
    @Override
    public Optional<LoanDTO> findByBookId(int bookId) {
        return getLoanRepository().findByBookId(bookId);
    }

    /**
     * Count by member id long.
     *
     * @param memberId the member id
     * @return the long
     */
    @Override
    public long countByMemberId(int memberId) {
        return getLoanRepository().countByMemberId(memberId);
    }

    /**
     * Count by member id and expire date long.
     *
     * @param memberId the member id
     * @param date the date
     * @return the long
     */
    @Override
    public long countByMemberIdAndExpireDate(int memberId, LocalDate date) {
        return getLoanRepository().countByMemberIdAndExpireDateIsBefore(memberId, date);
    }

    /**
     * Find by member id optional.
     *
     * @param memberId the member id
     * @return the optional
     */
    @Override
    public Optional<List<LoanDTO>> findByMemberId(int memberId) {
        return getLoanRepository().findByMemberId(memberId);
    }

    /**
     * Delete.
     *
     * @param loanId the loan id
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(int loanId) {
        getLoanRepository().deleteById(loanId);
    }


    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
