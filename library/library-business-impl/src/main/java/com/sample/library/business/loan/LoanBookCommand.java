package com.sample.library.business.loan;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.sample.library.business.ICommand;
import com.sample.library.dal.service.ILoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Loan book command.
 */
public class LoanBookCommand implements ICommand<LoanBookResp, LoanBookParam> {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoanBookCommand.class);

    /** The constant ADDING_LOAN. */
    private static final String ADDING_LOAN = "Adding Loan for Member ID {} and Book ID {}";

    /** The constant MAX_LOANS_EXCEEDED. */
    private static final String MAX_LOANS_EXCEEDED = "Max loans exceeded";

    /** The constant OVERDUE_LOANS_EXISTS. */
    private static final String OVERDUE_LOANS_EXISTS = "Overdue loans exists";

    /** The constant BOOK_NOT_AVAILABLE. */
    private static final String BOOK_NOT_AVAILABLE = "Book not available";

    /** The constant MAX_OVERDUE_COUNT. */
    private static final int MAX_OVERDUE_COUNT = 0;

    /** The Loan service. */
    private ILoanService loanService;

    /** The Max loans. */
    private int maxLoans;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Loan book command.
     *
     * @param loanService the loan service
     * @param maxLoans the max loans
     */
    public LoanBookCommand(final ILoanService loanService, final int maxLoans) {
        super();
        this.loanService = loanService;
        this.maxLoans = maxLoans;
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
     * Gets max loans.
     *
     * @return the max loans
     */
    public int getMaxLoans() {
        return this.maxLoans;
    }

    /**
     * Execute loan book resp.
     *
     * @param param the param
     * @return the loan book resp
     */
    @Override
    public LoanBookResp execute(LoanBookParam param) {
        LOGGER.info(ADDING_LOAN, param.getLoan().getMember().getId(), param.getLoan().getBook().getId());

        //can member loan book
        if(getLoanService().countByMemberId(param.getLoan().getMember().getId()) >= getMaxLoans()) {
            LOGGER.error(MAX_LOANS_EXCEEDED);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MAX_LOANS_EXCEEDED);
        }

        //has member any outstanding loans
        if(getLoanService().countByMemberIdAndExpireDate(param.getLoan().getMember().getId(), LocalDate.now()) > MAX_OVERDUE_COUNT) {
            LOGGER.error(OVERDUE_LOANS_EXISTS);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, OVERDUE_LOANS_EXISTS);
        }

        //is book available
        if(getLoanService().findByBookId(param.getLoan().getBook().getId()).isPresent()) {
            LOGGER.error(BOOK_NOT_AVAILABLE);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, BOOK_NOT_AVAILABLE);
        }

        return new LoanBookResp(getLoanService().save(param.getLoan()));
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
