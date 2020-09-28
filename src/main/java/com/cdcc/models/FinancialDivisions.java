package com.cdcc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "financial-divisions")
public class FinancialDivisions {

	@Id
	public String id;
	public String division_num;


	// Constructors
	public FinancialDivisions() {
	}

	public FinancialDivisions(String id, String division_num) {
		this.id = id;
		this.division_num = division_num;
	}

	// ObjectId needs to be converted to string
	public String getid() {
		return id.toString();
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getDivision_num() {
		return division_num;
	}

	public void setDivision_num(String division_num) {
		this.division_num = division_num;
	}

	
}
