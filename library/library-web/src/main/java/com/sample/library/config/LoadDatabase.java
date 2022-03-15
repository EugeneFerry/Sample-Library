package com.sample.library.config;

import static com.sample.library.dal.type.CategoryType.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.library.dal.dto.BookDTO;
import com.sample.library.dal.dto.CategoryDTO;
import com.sample.library.dal.dto.MemberDTO;
import com.sample.library.dal.repository.BookRepository;
import com.sample.library.dal.repository.CategoryRepository;
import com.sample.library.dal.repository.MemberRepository;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Load database.
 */
@Configuration
public class LoadDatabase {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

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
     * Init database command line runner.
     *
     * @param memberRepo the member repo
     * @param categoryRepo the category repo
     * @param bookRepo the book repo
     * @return the command line runner
     */
    @Bean
    CommandLineRunner initDatabase(MemberRepository memberRepo, CategoryRepository categoryRepo, BookRepository bookRepo) {

        MemberDTO user1 = new MemberDTO(1, "User1", "user@email.com");
        MemberDTO user2 = new MemberDTO(2, "User2", "user@email.com");
        MemberDTO user3 = new MemberDTO(3, "User3", "user@email.com");

        CategoryDTO cat1 = new CategoryDTO(ACTION_ADVENTURE.getId(), ACTION_ADVENTURE.getName());
        CategoryDTO cat2 = new CategoryDTO(THRILLER.getId(), THRILLER.getName());
        CategoryDTO cat3 = new CategoryDTO(HORROR.getId(), HORROR.getName());
        CategoryDTO cat4 = new CategoryDTO(ROMANCE.getId(), ROMANCE.getName());

        BookDTO book1 = new BookDTO(1, "author1", "title1", Lists.newArrayList(cat1));
        BookDTO book2 = new BookDTO(2, "author2", "title2", Lists.newArrayList(cat2));
        BookDTO book3 = new BookDTO(3, "author3", "title3", Lists.newArrayList(cat3));
        BookDTO book4 = new BookDTO(4, "author4", "title4", Lists.newArrayList(cat4));


        return args -> {
            LOGGER.info("Preloading member" + memberRepo.save(user1));
            LOGGER.info("Preloading member" + memberRepo.save(user2));
            LOGGER.info("Preloading member" + memberRepo.save(user3));

            LOGGER.info("Preloading category" + categoryRepo.save(cat1));
            LOGGER.info("Preloading category" + categoryRepo.save(cat2));
            LOGGER.info("Preloading category" + categoryRepo.save(cat3));
            LOGGER.info("Preloading category" + categoryRepo.save(cat4));

            LOGGER.info("Preloading book" + bookRepo.save(book1));
            LOGGER.info("Preloading book" + bookRepo.save(book2));
            LOGGER.info("Preloading book" + bookRepo.save(book3));
            LOGGER.info("Preloading book" + bookRepo.save(book4));
        };
    }
    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
