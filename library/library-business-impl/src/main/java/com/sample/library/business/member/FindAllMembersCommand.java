package com.sample.library.business.member;

import com.sample.library.business.ICommand;
import com.sample.library.dal.service.IMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Find all members command.
 */
public class FindAllMembersCommand implements ICommand<FindAllMembersResp, Void> {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FindAllMembersCommand.class);

    /** The constant RETRIEVING_MEMBERS. */
    private static final String RETRIEVING_MEMBERS = "Retrieving All Members";

    /** The Member service. */
    private IMemberService memberService;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Find all members command.
     *
     * @param memberService the member service
     */
    public FindAllMembersCommand(final IMemberService memberService) {
        super();
        this.memberService = memberService;
    }

    // ===========================================
    // Public Methods
    // ===========================================


    /**
     * Gets member service.
     *
     * @return the member service
     */
    public IMemberService getMemberService() {
        return this.memberService;
    }

    /**
     * Execute find all members resp.
     *
     * @param param the param
     * @return the find all members resp
     */
    @Override
    public FindAllMembersResp execute(Void param) {
        LOGGER.info(RETRIEVING_MEMBERS);
        return new FindAllMembersResp(getMemberService().findAll());
    }


    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
