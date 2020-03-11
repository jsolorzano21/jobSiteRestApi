package com.cdcc.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "financial-management-adjustment")
public class FinancialManagementAdjustment {

	@Id
	public String id;
	public String year;
	public String quarter;
	public String ma_revenue;
	public String ma_profit;
	public String division;


	// Constructors
	public FinancialManagementAdjustment() {
	}

	public FinancialManagementAdjustment(String id, String year, String quarter,  String ma_revenue, String ma_profit, String division) {
		this.id = id;
		this.year = year;
		this.quarter = quarter;
		this.ma_revenue = ma_revenue;
		this.ma_profit = ma_profit;
		this.division = division;
	}

	// ObjectId needs to be converted to string
	public String getid() {
		return id.toString();
	}

	public void setid(String id) {
		this.id = id;
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
	
	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getMa_revenue() {
		return ma_revenue;
	}

	public void setMa_revenue(String ma_revenue) {
		this.ma_revenue = ma_revenue;
	}

	public String getMa_profit() {
		return ma_profit;
	}

	public void setMa_profit(String ma_profit) {
		this.ma_profit = ma_profit;
	}

	
	
}
