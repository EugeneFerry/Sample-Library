package com.sample.library.controller.exception;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Rest request exception handler.
 */
@ControllerAdvice
public class RestRequestExceptionHandler extends ResponseEntityExceptionHandler {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(RestRequestExceptionHandler.class);

    /** The constant RESTFUL_REQUEST_EXCEPTION_MSG. */
    private static final String RESTFUL_REQUEST_EXCEPTION_MSG = "RESTful request exception {}";

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
     * Handle runtime exception response entity.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        LOGGER.error(RESTFUL_REQUEST_EXCEPTION_MSG, ex.getMessage());
        return handleExceptionInternal(ex, responseBody(ex, request, HttpStatus.INTERNAL_SERVER_ERROR), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    /**
     * Handle data integrity violation exception response entity.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        LOGGER.error(RESTFUL_REQUEST_EXCEPTION_MSG, ex.getMessage());
        return handleExceptionInternal(ex, responseBody(ex, request, HttpStatus.CONFLICT), new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    /**
     * Handle response status exception exception response entity.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(value = {ResponseStatusException.class})
    public ResponseEntity<Object> handleResponseStatusExceptionException(ResponseStatusException ex, WebRequest request) {
        LOGGER.error(RESTFUL_REQUEST_EXCEPTION_MSG, ex.getMessage());
        return handleExceptionInternal(ex, responseBody(ex, request, ex.getStatus()), new HttpHeaders(), ex.getStatus(), request);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    /**
     * Handle method argument not valid response entity.
     *
     * @param ex the ex
     * @param headers the headers
     * @param status the status
     * @param request the request
     * @return the response entity
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGER.error(RESTFUL_REQUEST_EXCEPTION_MSG, ex.getMessage());

        List<ExceptionDescription> errors = new ArrayList<>();

        for (ObjectError err : ex.getBindingResult().getAllErrors()) {
            errors.add(new ExceptionDescription(err.getDefaultMessage(), field(ex), path(request), status));
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle bind exception response entity.
     *
     * @param ex the ex
     * @param headers the headers
     * @param status the status
     * @param request the request
     * @return the response entity
     */
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGER.error(ex.getMessage());

        List<ExceptionDescription> errors = new ArrayList<>();

        for (FieldError error : ex.getFieldErrors()) {
            errors.add(new ExceptionDescription(error.getDefaultMessage(), error.getField(), path(request), status));
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // ===========================================
    // Private Methods
    // ===========================================

    /**
     * Field string.
     *
     * @param ex the ex
     * @return the string
     */
    private String field(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return (fieldError != null ? fieldError.getField() : StringUtils.EMPTY);
    }

    /**
     * Response body exception description.
     *
     * @param ex the ex
     * @param request the request
     * @param status the status
     * @return the exception description
     */
    private ExceptionDescription responseBody(Exception ex, WebRequest request, HttpStatus status) {
        return new ExceptionDescription(ex.getMessage(), StringUtils.EMPTY, path(request), status);
    }

    /**
     * Path string.
     *
     * @param webRequest the web request
     * @return the string
     */
    private String path(WebRequest webRequest) {
        String path = StringUtils.EMPTY;

        HttpServletRequest httpServletRequest = getHttpServletRequest(webRequest);
        if (httpServletRequest != null) {
            path = httpServletRequest.getPathInfo();
        }

        return path;
    }

    /**
     * Gets http servlet request.
     *
     * @param webRequest the web request
     * @return the http servlet request
     */
    private HttpServletRequest getHttpServletRequest(WebRequest webRequest) {

        HttpServletRequest request = null;

        if (webRequest instanceof ServletWebRequest) {
            request = ((ServletWebRequest) webRequest).getRequest();
        }

        return request;
    }

}
