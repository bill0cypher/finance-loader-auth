package com.finance.auth.financeauth.service;

import com.finance.auth.financeauth.model.Institution;
import com.finance.auth.financeauth.repo.InstitutionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> findAll() {
        log.info("Reading institutions...");
        return institutionRepository.findAll();
    }
}
