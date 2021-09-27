package com.finance.auth.financeauth.repo;

import com.finance.auth.financeauth.model.Institution;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends MongoRepository<Institution, String> {
}
