package com.cdcc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "financial-year-3-exec-adj")
public class FinancialUpdateYearThreeReportExecAdj {

	@Id
	public String id;
	public String quarter;
	public String year;
	public String division;
	public String year_1_revenue;
	public String year_1_profit;
	public String year_2_revenue;
	public String year_2_profit;
	public String year_3_revenue;
	public String year_3_profit;


	// Constructors
	public FinancialUpdateYearThreeReportExecAdj() {
	}

	public FinancialUpdateYearThreeReportExecAdj(String id, String quarter, String year, String division,
			String year_1_revenue, String year_1_profit, String year_2_revenue, String year_2_profit, String year_3_revenue, String year_3_profit) {
		this.id = id;
		this.quarter = quarter;
		this.year = year;
		this.division = division;
		this.year_1_revenue = year_1_revenue;
		this.year_1_profit = year_1_profit;
		this.year_2_revenue = year_2_revenue;
		this.year_2_profit = year_2_profit;
		this.year_3_revenue = year_3_revenue;
		this.year_3_profit = year_3_profit;
		
	}

	// ObjectId needs to be converted to string
	public String getid() {
		return id.toString();
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getYear_1_revenue() {
		return year_1_revenue;
	}

	public void setYear_1_revenue(String year_1_revenue) {
		this.year_1_revenue = year_1_revenue;
	}

	public String getYear_2_revenue() {
		return year_2_revenue;
	}

	public void setYear_2_revenue(String year_2_revenue) {
		this.year_2_revenue = year_2_revenue;
	}

	public String getYear_3_revenue() {
		return year_3_revenue;
	}

	public void setYear_3_revenue(String year_3_revenue) {
		this.year_3_revenue = year_3_revenue;
	}

	public String getYear_1_profit() {
		return year_1_profit;
	}

	public void setYear_1_profit(String year_1_profit) {
		this.year_1_profit = year_1_profit;
	}

	public String getYear_2_profit() {
		return year_2_profit;
	}

	public void setYear_2_profit(String year_2_profit) {
		this.year_2_profit = year_2_profit;
	}

	public String getYear_3_profit() {
		return year_3_profit;
	}

	public void setYear_3_profit(String year_3_profit) {
		this.year_3_profit = year_3_profit;
	}

	
	
}
