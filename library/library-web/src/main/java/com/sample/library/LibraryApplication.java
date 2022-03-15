package com.sample.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Library application.
 */
@SpringBootApplication
public class LibraryApplication {

	// ===========================================
	// Public Members
	// ===========================================

	// ===========================================
	// Private Members
	// ===========================================

	/** The constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LibraryApplication.class);

	/** The constant STARTED_MSG. */
	private static final String STARTED_MSG = "Application started.....";

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
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
		LOGGER.info(STARTED_MSG);
	}

	// ===========================================
	// Protected Methods
	// ===========================================

	// ===========================================
	// Private Methods
	// ===========================================



}
