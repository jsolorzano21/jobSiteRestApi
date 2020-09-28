package com.cdcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialUpdateCurrentQuarter;

public interface FinancialUpdateQuarterRepository extends MongoRepository<FinancialUpdateCurrentQuarter, String> {
	@Override
	void delete(FinancialUpdateCurrentQuarter deleted);

}