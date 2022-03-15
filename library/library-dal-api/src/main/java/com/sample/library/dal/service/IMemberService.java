package com.sample.library.dal.service;

import java.util.List;
import java.util.Optional;

import com.sample.library.dal.dto.MemberDTO;

/**
 * The interface Member service.
 */
public interface IMemberService {

    // ===========================================
    // Constants
    // ===========================================

    // ===========================================
    // Methods
    // ===========================================

    /**
     * Save member dto.
     *
     * @param member the member
     * @return the member dto
     */
    MemberDTO save(final MemberDTO member);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<MemberDTO> findAll();

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<MemberDTO> findById(final int id);

    /**
     * Delete.
     *
     * @param member the member
     */
    void delete(final MemberDTO member);
}
