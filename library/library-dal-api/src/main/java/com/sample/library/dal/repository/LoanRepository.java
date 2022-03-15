package com.sample.library.dal.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sample.library.dal.dto.LoanDTO;

/**
 * The interface Loan repository.
 */
public interface LoanRepository extends JpaRepository<LoanDTO, Integer> {

    /**
     * Find by book id optional.
     *
     * @param bookId the book id
     * @return the optional
     */
    Optional<LoanDTO> findByBookId(@Param("bookId") final int bookId);

    /**
     * Count by member id long.
     *
     * @param memberId the member id
     * @return the long
     */
    long countByMemberId(@Param("memberId") final int memberId);

    /**
     * Count by member id and expire date is before long.
     *
     * @param memberId the member id
     * @param date the date
     * @return the long
     */
    long countByMemberIdAndExpireDateIsBefore(@Param("memberId") final int memberId, @Param("date") final LocalDate date);

    /**
     * Find by member id optional.
     *
     * @param memberId the member id
     * @return the optional
     */
    Optional<List<LoanDTO>> findByMemberId(@Param("memberId") final int memberId);
}
