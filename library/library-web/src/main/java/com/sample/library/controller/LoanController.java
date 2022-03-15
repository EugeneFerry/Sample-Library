package com.sample.library.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.library.business.ICommand;
import com.sample.library.business.loan.FindLoansParam;
import com.sample.library.business.loan.FindLoansResp;
import com.sample.library.business.loan.LoanBookParam;
import com.sample.library.business.loan.LoanBookResp;
import com.sample.library.business.loan.ReturnBookParam;
import com.sample.library.dal.dto.BookDTO;
import com.sample.library.dal.dto.LoanDTO;
import com.sample.library.dal.dto.MemberDTO;
import com.sample.library.request.LoanRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Loan controller.
 */
@RestController
@RequestMapping("api/loans")
public class LoanController {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    /** The Loan book command. */
    @Autowired
    private ICommand<LoanBookResp, LoanBookParam> loanBookCommand;

    /** The Return book command. */
    @Autowired
    private ICommand<Void, ReturnBookParam> returnBookCommand;

    /** The Find loans command. */
    @Autowired
    private ICommand<FindLoansResp, FindLoansParam> findLoansCommand;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets loan book command.
     *
     * @return the loan book command
     */
    public ICommand<LoanBookResp, LoanBookParam> getLoanBookCommand() {
        return this.loanBookCommand;
    }

    /**
     * Sets loan book command.
     *
     * @param loanBookCommand the loan book command
     */
    public void setLoanBookCommand(ICommand<LoanBookResp, LoanBookParam> loanBookCommand) {
        this.loanBookCommand = loanBookCommand;
    }

    /**
     * Gets return book command.
     *
     * @return the return book command
     */
    public ICommand<Void, ReturnBookParam> getReturnBookCommand() {
        return this.returnBookCommand;
    }

    /**
     * Sets return book command.
     *
     * @param returnBookCommand the return book command
     */
    public void setReturnBookCommand(ICommand<Void, ReturnBookParam> returnBookCommand) {
        this.returnBookCommand = returnBookCommand;
    }

    /**
     * Gets find loans command.
     *
     * @return the find loans command
     */
    public ICommand<FindLoansResp, FindLoansParam> getFindLoansCommand() {
        return this.findLoansCommand;
    }

    /**
     * Sets find loans command.
     *
     * @param findLoansCommand the find loans command
     */
    public void setFindLoansCommand(ICommand<FindLoansResp, FindLoansParam> findLoansCommand) {
        this.findLoansCommand = findLoansCommand;
    }

    /**
     * Loan book response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<LoanDTO> loanBook(@Valid @RequestBody LoanRequest request) {
        LoanBookResp resp = getLoanBookCommand().execute(loanBookParam(request));
        return ResponseEntity.created(URI.create("/api/loans/")).body(resp.getLoan());
    }

    /**
     * Return book response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity returnBook(@PathVariable int id) {
        getReturnBookCommand().execute(new ReturnBookParam(id));
        return ResponseEntity.ok().build();
    }

    /**
     * Gets by member id.
     *
     * @param id the id
     * @return the by member id
     */
    @GetMapping("/member/{id}")
    public ResponseEntity<List<LoanDTO>> getByMemberId(@PathVariable int id) {
        FindLoansResp resp = getFindLoansCommand().execute(new FindLoansParam(id));
        return ResponseEntity.ok(resp.getLoans());
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

    /**
     * Loan book param loan book param.
     *
     * @param request the request
     * @return the loan book param
     */
    private LoanBookParam loanBookParam(final LoanRequest request) {
        LoanDTO loan = new LoanDTO();
        loan.setBook(new BookDTO(request.getBookId()));
        loan.setMember(new MemberDTO(request.getMemberId()));
        loan.setIssueDate(LocalDate.now());
        loan.setExpireDate(LocalDate.now().plusWeeks(1));
        return new LoanBookParam(loan);
    }

}
