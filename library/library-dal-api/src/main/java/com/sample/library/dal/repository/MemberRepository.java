package com.sample.library.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.library.dal.dto.MemberDTO;

/**
 * The interface Member repository.
 */
public interface MemberRepository extends JpaRepository<MemberDTO, Integer> {
}
