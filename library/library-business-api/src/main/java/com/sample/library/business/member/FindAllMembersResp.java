package com.sample.library.business.member;

import java.util.List;

import com.sample.library.dal.dto.MemberDTO;

/**
 * The type Find all members resp.
 */
public class FindAllMembersResp {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Members. */
    private List<MemberDTO> members;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Find all members resp.
     *
     * @param members the members
     */
    public FindAllMembersResp(final List<MemberDTO> members) {
        super();
        this.members = members;
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets members.
     *
     * @return the members
     */
    public List<MemberDTO> getMembers() {
        return this.members;
    }

    /**
     * Sets members.
     *
     * @param members the members
     */
    public void setMembers(List<MemberDTO> members) {
        this.members = members;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("FindAllMembersResp [members=%s]",
                this.members);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
