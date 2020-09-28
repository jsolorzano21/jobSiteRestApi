package com.cdcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialDataActualBudget;

public interface FinancialActualBudgetRepository extends MongoRepository<FinancialDataActualBudget, String> {
	@Override
	void delete(FinancialDataActualBudget deleted);
}