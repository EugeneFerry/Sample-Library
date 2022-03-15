package com.sample.library.business.book;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.sample.library.business.ICommand;
import com.sample.library.dal.dto.BookDTO;
import com.sample.library.dal.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Find book command.
 */
public class FindBookCommand implements ICommand<FindBookResp, FindBookParam> {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FindBookCommand.class);

    /** The constant RETRIEVING_BOOK. */
    private static final String RETRIEVING_BOOK = "Retrieving Book with ID {}";

    /** The constant BOOK_NOT_AVAILABLE. */
    private static final String BOOK_NOT_AVAILABLE = "Book not available";

    /** The Book service. */
    private IBookService bookService;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Find book command.
     *
     * @param bookService the book service
     */
    public FindBookCommand(final IBookService bookService) {
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
     * Execute find book resp.
     *
     * @param param the param
     * @return the find book resp
     */
    @Override
    public FindBookResp execute(FindBookParam param) {
        LOGGER.info(RETRIEVING_BOOK, param.getBookId());
        Optional<BookDTO> book = getBookService().findById(param.getBookId());
        if(book.isEmpty()){
            LOGGER.error(BOOK_NOT_AVAILABLE);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, BOOK_NOT_AVAILABLE);
        }
        return new FindBookResp(book.get());
    }


    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
