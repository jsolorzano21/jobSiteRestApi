package com.cdcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialUpdateYearThreeReport;

public interface FinancialUpdateYearThreeReportRepository extends MongoRepository<FinancialUpdateYearThreeReport, String> {
	@Override
	void delete(FinancialUpdateYearThreeReport deleted);

}