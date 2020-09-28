package com.cdcc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "financial-actual-numbers")
public class FinancialActualRevenue {

	@Id
	public String id;
	public String year;
	public String month;
	public String division;
	public String actual;



	// Constructors
	public FinancialActualRevenue() {
	}

	public FinancialActualRevenue(String id, String year, String month, String division, String actual) {
		this.id = id;
		this.year = year;
		this.month = month;
		this.division = division;
		this.actual = actual;

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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getActual() {
		return actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	
}
