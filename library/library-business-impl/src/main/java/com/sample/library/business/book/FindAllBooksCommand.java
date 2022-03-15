package com.sample.library.business.book;

import com.sample.library.business.ICommand;
import com.sample.library.dal.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Find all books command.
 */
public class FindAllBooksCommand implements ICommand<FindAllBooksResp, Void> {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FindAllBooksCommand.class);

    /** The constant RETRIEVING_BOOKS. */
    private static final String RETRIEVING_BOOKS = "Retrieving All Books";

    /** The Book service. */
    private IBookService bookService;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Find all books command.
     *
     * @param bookService the book service
     */
    public FindAllBooksCommand(final IBookService bookService) {
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
     * Execute find all books resp.
     *
     * @param param the param
     * @return the find all books resp
     */
    @Override
    public FindAllBooksResp execute(Void param) {
        LOGGER.info(RETRIEVING_BOOKS);
        return new FindAllBooksResp(getBookService().findAll());
    }


    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
