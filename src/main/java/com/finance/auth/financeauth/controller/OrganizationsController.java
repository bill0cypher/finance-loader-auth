package com.finance.auth.financeauth.controller;

import com.finance.auth.financeauth.model.Institution;
import com.finance.auth.financeauth.service.InstitutionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationsController {

    private final InstitutionService institutionService;

    public OrganizationsController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/top")
    public ResponseEntity<List<Institution>> showInstitutions() {
        return ResponseEntity.ok(institutionService.findAll());
    }
}
