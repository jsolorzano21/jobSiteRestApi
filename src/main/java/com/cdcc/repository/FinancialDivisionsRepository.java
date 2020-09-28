package com.cdcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialDivisions;


public interface FinancialDivisionsRepository extends MongoRepository<FinancialDivisions, String> {
	@Override
	void delete(FinancialDivisions deleted);

}