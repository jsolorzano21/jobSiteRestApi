package com.cdcc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "financial-year-quarter-history")
public class FinancialYearlyQuarterLabel {

	@Id
	public String id;
	public String label;


	// Constructors
	public FinancialYearlyQuarterLabel() {
	}

	public FinancialYearlyQuarterLabel(String id, String label) {
		this.id = id;
		this.label = label;
	}

	// ObjectId needs to be converted to string
	public String getid() {
		return id.toString();
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
}
