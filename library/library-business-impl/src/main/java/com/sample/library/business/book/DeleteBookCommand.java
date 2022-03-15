package com.sample.library.business.book;

import com.sample.library.business.ICommand;
import com.sample.library.dal.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Delete book command.
 */
public class DeleteBookCommand implements ICommand<Void, DeleteBookParam> {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteBookCommand.class);

    /** The constant DELETING_BOOK. */
    private static final String DELETING_BOOK = "Deleting Book with ID {}";

    /** The Book service. */
    private IBookService bookService;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Delete book command.
     *
     * @param bookService the book service
     */
    public DeleteBookCommand(final IBookService bookService) {
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
     * Execute void.
     *
     * @param param the param
     * @return the void
     */
    @Override
    public Void execute(DeleteBookParam param) {
        LOGGER.info(DELETING_BOOK, param.getBookId());
        getBookService().delete(param.getBookId());
        return null;
    }


    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
