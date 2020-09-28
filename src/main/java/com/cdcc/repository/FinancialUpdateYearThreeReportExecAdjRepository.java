package com.cdcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialUpdateYearThreeReportExecAdj;

public interface FinancialUpdateYearThreeReportExecAdjRepository extends MongoRepository<FinancialUpdateYearThreeReportExecAdj, String> {
	@Override
	void delete(FinancialUpdateYearThreeReportExecAdj deleted);

}