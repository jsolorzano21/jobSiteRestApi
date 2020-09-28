package com.cdcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialUserInformation;

public interface FinancialUserInformationRepository extends MongoRepository<FinancialUserInformation, String> {
	@Override
	void delete(FinancialUserInformation deleted);

}