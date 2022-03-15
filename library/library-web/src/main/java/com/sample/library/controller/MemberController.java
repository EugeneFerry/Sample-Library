package com.sample.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.library.business.ICommand;
import com.sample.library.business.member.FindAllMembersResp;
import com.sample.library.dal.dto.MemberDTO;

/**
 * The type Member controller.
 */
@RestController
@RequestMapping("api/members")
public class MemberController {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Find all members command. */
    @Autowired
    private ICommand<FindAllMembersResp, Void> findAllMembersCommand;

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
     * Gets find all members command.
     *
     * @return the find all members command
     */
    public ICommand<FindAllMembersResp, Void> getFindAllMembersCommand() {
        return this.findAllMembersCommand;
    }

    /**
     * Sets find all members command.
     *
     * @param findAllMembersCommand the find all members command
     */
    public void setFindAllMembersCommand(ICommand<FindAllMembersResp, Void> findAllMembersCommand) {
        this.findAllMembersCommand = findAllMembersCommand;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAll() {
        FindAllMembersResp resp = getFindAllMembersCommand().execute(null);
        return ResponseEntity.ok(resp.getMembers());
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
