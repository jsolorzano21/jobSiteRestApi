package com.cdcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialUserInformation;
import com.cdcc.models.FinancialYearlyQuarterLabel;

public interface FinancialYearlyQuarterLabelRepository extends MongoRepository<FinancialYearlyQuarterLabel, String> {
	@Override
	void delete(FinancialYearlyQuarterLabel deleted);

}