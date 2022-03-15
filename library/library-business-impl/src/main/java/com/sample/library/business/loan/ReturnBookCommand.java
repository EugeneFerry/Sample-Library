package com.sample.library.business.loan;

import com.sample.library.business.ICommand;
import com.sample.library.dal.service.ILoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Return book command.
 */
public class ReturnBookCommand implements ICommand<Void, ReturnBookParam> {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReturnBookCommand.class);

    /** The constant DELETING_LOAN. */
    private static final String DELETING_LOAN = "Deleting Loan with ID {}";

    /** The Loan service. */
    private ILoanService loanService;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Return book command.
     *
     * @param loanService the loan service
     */
    public ReturnBookCommand(final ILoanService loanService) {
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
     * Execute void.
     *
     * @param param the param
     * @return the void
     */
    @Override
    public Void execute(ReturnBookParam param) {
        LOGGER.info(DELETING_LOAN, param.getLoadId());
        getLoanService().delete(param.getLoadId());
        return null;
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
