package com.cdcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialActualRevenue;
import com.cdcc.models.FinancialUpdateCurrentQuarter;

public interface FinancialActualRevenueRepository extends MongoRepository<FinancialActualRevenue, String> {
	@Override
	void delete(FinancialActualRevenue deleted);

}