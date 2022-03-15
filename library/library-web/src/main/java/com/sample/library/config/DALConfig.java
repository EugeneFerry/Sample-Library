package com.sample.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.library.dal.repository.BookRepository;
import com.sample.library.dal.repository.CategoryRepository;
import com.sample.library.dal.repository.LoanRepository;
import com.sample.library.dal.repository.MemberRepository;
import com.sample.library.dal.service.BookService;
import com.sample.library.dal.service.CategoryService;
import com.sample.library.dal.service.IBookService;
import com.sample.library.dal.service.ICategoryService;
import com.sample.library.dal.service.ILoanService;
import com.sample.library.dal.service.IMemberService;
import com.sample.library.dal.service.LoanService;
import com.sample.library.dal.service.MemberService;

/**
 * The type Dal config.
 */
@Configuration
public class DALConfig {

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
     * Instantiates a new Dal config.
     */
    public DALConfig() {
        super();
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Member service member service.
     *
     * @param memberRepository the member repository
     * @return the member service
     */
    @Bean
    public IMemberService memberService(MemberRepository memberRepository) {
        return new MemberService(memberRepository);
    }

    /**
     * Book service book service.
     *
     * @param bookRepository the book repository
     * @return the book service
     */
    @Bean
    public IBookService bookService(BookRepository bookRepository) {
        return new BookService(bookRepository);
    }

    /**
     * Loan service loan service.
     *
     * @param loanRepository the loan repository
     * @return the loan service
     */
    @Bean
    public ILoanService loanService(LoanRepository loanRepository) {
        return new LoanService(loanRepository);
    }

    /**
     * Category service category service.
     *
     * @param categoryRepository the category repository
     * @return the category service
     */
    @Bean
    public ICategoryService categoryService(CategoryRepository categoryRepository) {
        return new CategoryService(categoryRepository);
    }


    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
