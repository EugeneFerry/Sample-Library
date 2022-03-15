package com.sample.library.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import com.sample.library.business.book.AddBookParam;
import com.sample.library.business.book.AddBookResp;
import com.sample.library.business.book.DeleteBookParam;
import com.sample.library.business.book.FindAllBooksResp;
import com.sample.library.business.book.FindBookParam;
import com.sample.library.business.book.FindBookResp;
import com.sample.library.dal.dto.BookDTO;
import com.sample.library.dal.dto.CategoryDTO;
import com.sample.library.dal.type.CategoryType;
import com.sample.library.request.BookRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Book controller.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    /** The Add book command. */
    @Autowired
    private ICommand<AddBookResp, AddBookParam> addBookCommand;

    /** The Delete book command. */
    @Autowired
    private ICommand<Void, DeleteBookParam> deleteBookCommand;

    /** The Find book command. */
    @Autowired
    private ICommand<FindBookResp, FindBookParam> findBookCommand;

    /** The Find all books command. */
    @Autowired
    private ICommand<FindAllBooksResp, Void> findAllBooksCommand;

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
     * Gets add book command.
     *
     * @return the add book command
     */
    public ICommand<AddBookResp, AddBookParam> getAddBookCommand() {
        return this.addBookCommand;
    }

    /**
     * Sets add book command.
     *
     * @param addBookCommand the add book command
     */
    public void setAddBookCommand(ICommand<AddBookResp, AddBookParam> addBookCommand) {
        this.addBookCommand = addBookCommand;
    }

    /**
     * Gets delete book command.
     *
     * @return the delete book command
     */
    public ICommand<Void, DeleteBookParam> getDeleteBookCommand() {
        return this.deleteBookCommand;
    }

    /**
     * Sets delete book command.
     *
     * @param deleteBookCommand the delete book command
     */
    public void setDeleteBookCommand(ICommand<Void, DeleteBookParam> deleteBookCommand) {
        this.deleteBookCommand = deleteBookCommand;
    }

    /**
     * Gets find book command.
     *
     * @return the find book command
     */
    public ICommand<FindBookResp, FindBookParam> getFindBookCommand() {
        return this.findBookCommand;
    }

    /**
     * Sets find book command.
     *
     * @param findBookCommand the find book command
     */
    public void setFindBookCommand(ICommand<FindBookResp, FindBookParam> findBookCommand) {
        this.findBookCommand = findBookCommand;
    }

    /**
     * Gets find all books command.
     *
     * @return the find all books command
     */
    public ICommand<FindAllBooksResp, Void> getFindAllBooksCommand() {
        return this.findAllBooksCommand;
    }

    /**
     * Sets find all books command.
     *
     * @param findAllBooksCommand the find all books command
     */
    public void setFindAllBooksCommand(ICommand<FindAllBooksResp, Void> findAllBooksCommand) {
        this.findAllBooksCommand = findAllBooksCommand;
    }

    /**
     * Add book response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookRequest request) {
        AddBookResp resp = getAddBookCommand().execute(addBookParam(request));
        return ResponseEntity.created(URI.create("/api/books/")).body(resp.getBook());
    }

    /**
     * Delete book response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable int id) {
        getDeleteBookCommand().execute(new DeleteBookParam(id));
        return ResponseEntity.ok().build();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable int id) {
        FindBookResp resp = getFindBookCommand().execute(new FindBookParam(id));
        return ResponseEntity.ok(resp.getBook());
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAll() {
        FindAllBooksResp resp = getFindAllBooksCommand().execute(null);
        return ResponseEntity.ok(resp.getBooks());
    }


    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

    /**
     * Add book param add book param.
     *
     * @param request the request
     * @return the add book param
     */
    private AddBookParam addBookParam(final BookRequest request) {
        BookDTO book = new BookDTO();
        BeanUtils.copyProperties(request, book, "categories");
        book.setCategories(copyCategories(request.getCategories()));
        return new AddBookParam(book);
    }

    /**
     * Copy categories list.
     *
     * @param categoryTypes the category types
     * @return the list
     */
    private List<CategoryDTO> copyCategories(final List<CategoryType> categoryTypes) {
        List<CategoryDTO> categories = new ArrayList<>();
        for(CategoryType type: categoryTypes) {
            CategoryDTO category = new CategoryDTO();
            BeanUtils.copyProperties(type, category);
            categories.add(category);
        }
        return categories;
    }

}
