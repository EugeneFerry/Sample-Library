package com.sample.library.dal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.sample.library.dal.dto.LoanDTO;

/**
 * The interface Loan service.
 */
public interface ILoanService {

    // ===========================================
    // Constants
    // ===========================================

    // ===========================================
    // Methods
    // ===========================================

    /**
     * Save loan dto.
     *
     * @param loan the loan
     * @return the loan dto
     */
    LoanDTO save(final LoanDTO loan);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<LoanDTO> findById(final int id);

    /**
     * Find by book id optional.
     *
     * @param bookId the book id
     * @return the optional
     */
    Optional<LoanDTO> findByBookId(final int bookId);

    /**
     * Count by member id long.
     *
     * @param memberId the member id
     * @return the long
     */
    long countByMemberId(final int memberId);

    /**
     * Count by member id and expire date long.
     *
     * @param memberId the member id
     * @param date the date
     * @return the long
     */
    long countByMemberIdAndExpireDate(final int memberId, final LocalDate date);

    /**
     * Find by member id optional.
     *
     * @param member the member
     * @return the optional
     */
    Optional<List<LoanDTO>> findByMemberId(final int member);

    /**
     * Delete.
     *
     * @param loanId the loan id
     */
    void delete(final int loanId);
}
