package com.cdcc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialDataActualBudget;

public interface FinancialActualBudgetRepository extends CrudRepository<FinancialDataActualBudget, String> {
	@Override
	void delete(FinancialDataActualBudget deleted);
}