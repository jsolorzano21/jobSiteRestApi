package com.cdcc.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "financial-budget-actual")
public class FinancialDataActualBudget {

	@Id
	public ObjectId _id;

	public String department;
	public String account;
	public String name;
	public String status;
	public String year;
	public String quarter;
	public String period_1;
	public String period_2;
	public String period_3;
	public String period_4;
	public String period_5;
	public String period_6;
	public String period_7;
	public String period_8;
	public String period_9;
	public String period_10;
	public String period_11;
	public String period_12;

	// Constructors
	public FinancialDataActualBudget() {
	}

	public FinancialDataActualBudget(ObjectId _id, String department, String account,  String name, String status, String year, String quarter, String period_1, String period_2, String period_3,
			String period_4, String period_5, String period_6, String period_7, String period_8, String period_9, String period_10, String period_11, String period_12) {
		this._id = _id;
		this.department = department;
		this.account = account;
		this.name = name;
		this.status = status;
		this.year = year;
		this.quarter = quarter;
		this.period_1 = period_1;
		this.period_2 = period_2;
		this.period_3 = period_3;
		this.period_4 = period_4;
		this.period_5 = period_5;
		this.period_6 = period_6;
		this.period_7 = period_7;
		this.period_8 = period_8;
		this.period_9 = period_9;
		this.period_10 = period_10;
		this.period_11 = period_11;
		this.period_12 = period_12;
	}

	// ObjectId needs to be converted to string
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getPeriod_1() {
		return period_1;
	}

	public void setPeriod_1(String period_1) {
		this.period_1 = period_1;
	}

	public String getPeriod_2() {
		return period_2;
	}

	public void setPeriod_2(String period_2) {
		this.period_2 = period_2;
	}

	public String getPeriod_3() {
		return period_3;
	}

	public void setPeriod_3(String period_3) {
		this.period_3 = period_3;
	}

	public String getPeriod_4() {
		return period_4;
	}

	public void setPeriod_4(String period_4) {
		this.period_4 = period_4;
	}

	public String getPeriod_5() {
		return period_5;
	}

	public void setPeriod_5(String period_5) {
		this.period_5 = period_5;
	}

	public String getPeriod_6() {
		return period_6;
	}

	public void setPeriod_6(String period_6) {
		this.period_6 = period_6;
	}

	public String getPeriod_7() {
		return period_7;
	}

	public void setPeriod_7(String period_7) {
		this.period_7 = period_7;
	}

	public String getPeriod_8() {
		return period_8;
	}

	public void setPeriod_8(String period_8) {
		this.period_8 = period_8;
	}

	public String getPeriod_9() {
		return period_9;
	}

	public void setPeriod_9(String period_9) {
		this.period_9 = period_9;
	}

	public String getPeriod_10() {
		return period_10;
	}

	public void setPeriod_10(String period_10) {
		this.period_10 = period_10;
	}
	
	public String getPeriod_11() {
		return period_11;
	}

	public void setPeriod_11(String period_11) {
		this.period_11 = period_11;
	}
	
	public String getPeriod_12() {
		return period_12;
	}

	public void setPeriod_12(String period_12) {
		this.period_12 = period_12;
	}
	
	
}
