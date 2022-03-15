package com.sample.library.business.loan;

import com.sample.library.business.ICommand;
import com.sample.library.dal.service.ILoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Find loans command.
 */
public class FindLoansCommand implements ICommand<FindLoansResp, FindLoansParam> {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FindLoansCommand.class);

    /** The constant RETRIEVING_LOAN. */
    private static final String RETRIEVING_LOAN = "Retrieving Loan with Member ID {}";

    /** The Loan service. */
    private ILoanService loanService;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Find loans command.
     *
     * @param loanService the loan service
     */
    public FindLoansCommand(final ILoanService loanService) {
        super();
        this.loanService = loanService;
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets loan service.
     *
     * @return the loan service
     */
    public ILoanService getLoanService() {
        return this.loanService;
    }


    /**
     * Execute find loans resp.
     *
     * @param param the param
     * @return the find loans resp
     */
    @Override
    public FindLoansResp execute(FindLoansParam param) {
        LOGGER.info(RETRIEVING_LOAN, param.getMemberId());
        return new FindLoansResp(getLoanService().findByMemberId(param.getMemberId()).get());
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
