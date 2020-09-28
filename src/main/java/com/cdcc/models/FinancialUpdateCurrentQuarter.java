package com.cdcc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "update-current-quarter")
public class FinancialUpdateCurrentQuarter {

	@Id
	public String id;
	public String current_quarter;
	public String current_year;



	// Constructors
	public FinancialUpdateCurrentQuarter() {
	}

	public FinancialUpdateCurrentQuarter(String id, String current_quarter, String current_year) {
		this.id = id;
		this.current_quarter = current_quarter;
		this.current_year = current_year;

	}

	// ObjectId needs to be converted to string
	public String getid() {
		return id.toString();
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getCurrent_quarter() {
		return current_quarter;
	}

	public void setCurrent_quarter(String current_quarter) {
		this.current_quarter = current_quarter;
	}
	
	public String getCurrent_year() {
		return current_year;
	}
	
	public void setCurrent_year(String current_year) {
		this.current_year = current_year;
	}
	
}
