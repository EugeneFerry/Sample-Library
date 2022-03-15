package com.sample.library.dal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.library.dal.dto.MemberDTO;
import com.sample.library.dal.repository.MemberRepository;

/**
 * The type Member service.
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class MemberService implements IMemberService {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Member repository. */
    private MemberRepository memberRepository;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Member service.
     */
    public MemberService() {
        super();
    }

    /**
     * Instantiates a new Member service.
     *
     * @param memberRepository the member repository
     */
    public MemberService(final MemberRepository memberRepository) {
        super();
        this.memberRepository = memberRepository;
    }

    // ===========================================
    // Public Methods
    // ===========================================


    /**
     * Gets member repository.
     *
     * @return the member repository
     */
    public MemberRepository getMemberRepository() {
        return this.memberRepository;
    }

    /**
     * Sets member repository.
     *
     * @param memberRepository the member repository
     */
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * Save member dto.
     *
     * @param member the member
     * @return the member dto
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public MemberDTO save(MemberDTO member) {
        return getMemberRepository().saveAndFlush(member);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<MemberDTO> findAll() {
        return getMemberRepository().findAll();
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<MemberDTO> findById(int id) {
        return getMemberRepository().findById(id);
    }

    /**
     * Delete.
     *
     * @param member the member
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(MemberDTO member) {
        getMemberRepository().delete(member);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
