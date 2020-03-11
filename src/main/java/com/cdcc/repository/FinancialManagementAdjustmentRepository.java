package com.cdcc.repository;

import java.util.Optional;

import javax.annotation.Generated;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.FinancialManagementAdjustment;

public interface FinancialManagementAdjustmentRepository extends CrudRepository<FinancialManagementAdjustment, String> {
	@Override
	void delete(FinancialManagementAdjustment deleted);

}