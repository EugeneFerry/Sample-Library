package com.sample.library.dal.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * The type Member dto test.
 */
class MemberDTOTest {

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

    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Test getters and setters.
     */
    @Test
    public void testGettersAndSetters() {
        MemberDTO member = new MemberDTO();
        member.setId(1);
        member.setName("name");
        member.setEmail("email");
        assertThat(member.getId()).isEqualTo(1);
        assertThat(member.getName()).isEqualTo("name");
        assertThat(member.getEmail()).isEqualTo("email");
    }


    /**
     * Test default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        MemberDTO member = new MemberDTO();
        assertThat(member.getId()).isNull();
        assertThat(member.getName()).isNull();
        assertThat(member.getEmail()).isNull();
    }

    /**
     * Test constructor 1.
     */
    @Test
    public void testConstructor1() {
        MemberDTO member = new MemberDTO(1);
        assertThat(member.getId()).isEqualTo(1);
        assertThat(member.getName()).isNull();
        assertThat(member.getEmail()).isNull();
    }

    /**
     * Test constructor 2.
     */
    @Test
    public void testConstructor2() {
        MemberDTO member = new MemberDTO(1, "name", "email");
        assertThat(member.getId()).isEqualTo(1);
        assertThat(member.getName()).isEqualTo("name");
        assertThat(member.getEmail()).isEqualTo("email");
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        String expectedString = "MemberDTO [id=null, name=null, email=null]";
        assertThat(new MemberDTO().toString()).isEqualTo(expectedString);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}