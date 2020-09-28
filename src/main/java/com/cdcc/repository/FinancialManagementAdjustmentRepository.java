package com.cdcc.repository;

import java.util.List;
import java.util.Optional;

import javax.annotation.Generated;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialDataResults;
import com.cdcc.models.FinancialManagementAdjustment;

public interface FinancialManagementAdjustmentRepository extends MongoRepository<FinancialManagementAdjustment, String> {
	@Override
	void delete(FinancialManagementAdjustment deleted);

	List<FinancialManagementAdjustment> findByYearAndQuarter(String year, String quarter);
}