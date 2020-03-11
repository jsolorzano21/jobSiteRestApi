package com.cdcc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialDataResults;

public interface FinancialResultsRepository extends CrudRepository<FinancialDataResults, String> {
	@Override
	void delete(FinancialDataResults deleted);
}