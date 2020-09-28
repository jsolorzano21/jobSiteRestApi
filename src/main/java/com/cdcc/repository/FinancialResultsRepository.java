package com.cdcc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialDataResults;

public interface FinancialResultsRepository extends MongoRepository<FinancialDataResults, String> {
	@Override
	void delete(FinancialDataResults deleted);
	
	List<FinancialDataResults> findByDivision(String division);
}