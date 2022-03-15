package com.sample.library.business.book;

import com.sample.library.business.ICommand;
import com.sample.library.dal.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Add book command.
 */
public class AddBookCommand implements ICommand<AddBookResp, AddBookParam> {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(AddBookCommand.class);

    /** The constant ADDING_BOOK. */
    private static final String ADDING_BOOK = "Adding Book {}";

    /** The Book service. */
    private IBookService bookService;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Add book command.
     *
     * @param bookService the book service
     */
    public AddBookCommand(final IBookService bookService) {
        super();
        this.bookService = bookService;
    }

    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets book service.
     *
     * @return the book service
     */
    public IBookService getBookService() {
        return this.bookService;
    }

    /**
     * Execute add book resp.
     *
     * @param param the param
     * @return the add book resp
     */
    @Override
    public AddBookResp execute(AddBookParam param) {
        LOGGER.info(ADDING_BOOK, param.getBook().getTitle());
        return new AddBookResp(getBookService().save(param.getBook()));
    }


    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
