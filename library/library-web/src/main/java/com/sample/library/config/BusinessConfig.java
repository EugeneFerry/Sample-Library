package com.sample.library.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.library.business.ICommand;
import com.sample.library.business.book.AddBookCommand;
import com.sample.library.business.book.AddBookParam;
import com.sample.library.business.book.AddBookResp;
import com.sample.library.business.book.DeleteBookCommand;
import com.sample.library.business.book.DeleteBookParam;
import com.sample.library.business.book.FindAllBooksCommand;
import com.sample.library.business.book.FindAllBooksResp;
import com.sample.library.business.book.FindBookCommand;
import com.sample.library.business.book.FindBookParam;
import com.sample.library.business.book.FindBookResp;
import com.sample.library.business.loan.FindLoansCommand;
import com.sample.library.business.loan.FindLoansParam;
import com.sample.library.business.loan.FindLoansResp;
import com.sample.library.business.loan.LoanBookCommand;
import com.sample.library.business.loan.LoanBookParam;
import com.sample.library.business.loan.LoanBookResp;
import com.sample.library.business.loan.ReturnBookCommand;
import com.sample.library.business.loan.ReturnBookParam;
import com.sample.library.business.member.FindAllMembersCommand;
import com.sample.library.business.member.FindAllMembersResp;
import com.sample.library.dal.service.IBookService;
import com.sample.library.dal.service.ILoanService;
import com.sample.library.dal.service.IMemberService;

/**
 * The type Business config.
 */
@Configuration
public class BusinessConfig {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Business config.
     */
    public BusinessConfig() {
        super();
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Find all members command command.
     *
     * @param memberService the member service
     * @return the command
     */
    @Bean
    public ICommand<FindAllMembersResp, Void> findAllMembersCommand(IMemberService memberService) {
        return new FindAllMembersCommand(memberService);
    }

    /**
     * Add book command command.
     *
     * @param bookService the book service
     * @return the command
     */
    @Bean
    public ICommand<AddBookResp, AddBookParam> addBookCommand(IBookService bookService) {
        return new AddBookCommand(bookService);
    }

    /**
     * Delete book command command.
     *
     * @param bookService the book service
     * @return the command
     */
    @Bean
    public ICommand<Void, DeleteBookParam> deleteBookCommand(IBookService bookService) {
        return new DeleteBookCommand(bookService);
    }

    /**
     * Find book command command.
     *
     * @param bookService the book service
     * @return the command
     */
    @Bean
    public ICommand<FindBookResp, FindBookParam> findBookCommand(IBookService bookService) {
        return new FindBookCommand(bookService);
    }

    /**
     * Find all books command command.
     *
     * @param bookService the book service
     * @return the command
     */
    @Bean
    public ICommand<FindAllBooksResp, Void> findAllBooksCommand(IBookService bookService) {
        return new FindAllBooksCommand(bookService);
    }

    /**
     * Loan book command command.
     *
     * @param LoanService the loan service
     * @param maxLoans the max loans
     * @return the command
     */
    @Bean
    public ICommand<LoanBookResp, LoanBookParam> loanBookCommand(ILoanService LoanService, @Value("${application.loans.maxLoans}") int maxLoans) {
        return new LoanBookCommand(LoanService, maxLoans);
    }

    /**
     * Return book command command.
     *
     * @param LoanService the loan service
     * @return the command
     */
    @Bean
    public ICommand<Void, ReturnBookParam> returnBookCommand(ILoanService LoanService) {
        return new ReturnBookCommand(LoanService);
    }

    /**
     * Find loans command command.
     *
     * @param LoanService the loan service
     * @return the command
     */
    @Bean
    public ICommand<FindLoansResp, FindLoansParam> findLoansCommand(ILoanService LoanService) {
        return new FindLoansCommand(LoanService);
    }


    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
