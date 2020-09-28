package com.cdcc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "financial-year-3-report")
public class FinancialUpdateYearThreeReport {

	@Id
	public String id;
	public String quarter;
	public String year;
	public String div_1_revenue_1;
	public String div_1_profit_1;
	public String div_1_revenue_2;
	public String div_1_profit_2;
	public String div_1_revenue_3;
	public String div_1_profit_3;
	public String div_2_revenue_1;
	public String div_2_profit_1;
	public String div_2_revenue_2;
	public String div_2_profit_2;
	public String div_2_revenue_3;
	public String div_2_profit_3;
	public String div_3_revenue_1;
	public String div_3_profit_1;
	public String div_3_revenue_2;
	public String div_3_profit_2;
	public String div_3_revenue_3;
	public String div_3_profit_3;
	public String div_4_revenue_1;
	public String div_4_profit_1;
	public String div_4_revenue_2;
	public String div_4_profit_2;
	public String div_4_revenue_3;
	public String div_4_profit_3;
	public String div_5_revenue_1;
	public String div_5_profit_1;
	public String div_5_revenue_2;
	public String div_5_profit_2;
	public String div_5_revenue_3;
	public String div_5_profit_3;
	public String div_6_revenue_1;
	public String div_6_profit_1;
	public String div_6_revenue_2;
	public String div_6_profit_2;
	public String div_6_revenue_3;
	public String div_6_profit_3;
	public String div_7_revenue_1;
	public String div_7_profit_1;
	public String div_7_revenue_2;
	public String div_7_profit_2;
	public String div_7_revenue_3;
	public String div_7_profit_3;
	public String div_11_revenue_1;
	public String div_11_profit_1;
	public String div_11_revenue_2;
	public String div_11_profit_2;
	public String div_11_revenue_3;
	public String div_11_profit_3;


	// Constructors
	public FinancialUpdateYearThreeReport() {
	}

	public FinancialUpdateYearThreeReport(String id, String quarter, String year, String div_1_revenue_1, String div_1_profit_1, String div_1_revenue_2, String div_1_profit_2,
			String div_1_revenue_3, String div_1_profit_3, String div_2_revenue_1, String div_2_profit_1, String div_2_revenue_2, String div_2_profit_2,
			String div_2_revenue_3, String div_2_profit_3, String div_3_revenue_1, String div_3_profit_1, String div_3_revenue_2, String div_3_profit_2,
			String div_3_revenue_3, String div_3_profit_3, String div_4_revenue_1, String div_4_profit_1, String div_4_revenue_2, String div_4_profit_2,
			String div_4_revenue_3, String div_4_profit_3, String div_5_revenue_1, String div_5_profit_1, String div_5_revenue_2, String div_5_profit_2,
			String div_5_revenue_3, String div_5_profit_3, String div_6_revenue_1, String div_6_profit_1, String div_6_revenue_2, String div_6_profit_2,
			String div_6_revenue_3, String div_6_profit_3, String div_7_revenue_1, String div_7_profit_1, String div_7_revenue_2, String div_7_profit_2,
			String div_7_revenue_3, String div_7_profit_3, String div_11_revenue_1, String div_11_profit_1, String div_11_revenue_2, String div_11_profit_2,
			String div_11_revenue_3, String div_11_profit_3) {
		this.id = id;
		this.quarter = quarter;
		this.year = year;
		this.div_1_revenue_1 = div_1_revenue_1;
		this.div_1_profit_1 = div_1_profit_1;
		this.div_1_revenue_2 = div_1_revenue_2;
		this.div_1_profit_2 = div_1_profit_2;
		this.div_1_revenue_3 = div_1_revenue_3;
		this.div_1_profit_3 = div_1_profit_3;
		this.div_2_revenue_1 = div_1_revenue_1;
		this.div_2_profit_1 = div_1_profit_1;
		this.div_2_revenue_2 = div_1_revenue_2;
		this.div_2_profit_2 = div_1_profit_2;
		this.div_2_revenue_3 = div_1_revenue_3;
		this.div_2_profit_3 = div_1_profit_3;
		this.div_3_revenue_1 = div_1_revenue_1;
		this.div_3_profit_1 = div_1_profit_1;
		this.div_3_revenue_2 = div_1_revenue_2;
		this.div_3_profit_2 = div_1_profit_2;
		this.div_3_revenue_3 = div_1_revenue_3;
		this.div_3_profit_3 = div_1_profit_3;
		this.div_4_revenue_1 = div_1_revenue_1;
		this.div_4_profit_1 = div_1_profit_1;
		this.div_4_revenue_2 = div_1_revenue_2;
		this.div_4_profit_2 = div_1_profit_2;
		this.div_4_revenue_3 = div_1_revenue_3;
		this.div_4_profit_3 = div_1_profit_3;
		this.div_5_revenue_1 = div_1_revenue_1;
		this.div_5_profit_1 = div_1_profit_1;
		this.div_5_revenue_2 = div_1_revenue_2;
		this.div_5_profit_2 = div_1_profit_2;
		this.div_5_revenue_3 = div_1_revenue_3;
		this.div_5_profit_3 = div_1_profit_3;
		this.div_6_revenue_1 = div_1_revenue_1;
		this.div_6_profit_1 = div_1_profit_1;
		this.div_6_revenue_2 = div_1_revenue_2;
		this.div_6_profit_2 = div_1_profit_2;
		this.div_6_revenue_3 = div_1_revenue_3;
		this.div_6_profit_3 = div_1_profit_3;
		this.div_7_revenue_1 = div_1_revenue_1;
		this.div_7_profit_1 = div_1_profit_1;
		this.div_7_revenue_2 = div_1_revenue_2;
		this.div_7_profit_2 = div_1_profit_2;
		this.div_7_revenue_3 = div_1_revenue_3;
		this.div_7_profit_3 = div_1_profit_3;
		this.div_11_revenue_1 = div_1_revenue_1;
		this.div_11_profit_1 = div_1_profit_1;
		this.div_11_revenue_2 = div_1_revenue_2;
		this.div_11_profit_2 = div_1_profit_2;
		this.div_11_revenue_3 = div_1_revenue_3;
		this.div_11_profit_3 = div_1_profit_3;
		
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

	public String getDiv_1_revenue_1() {
		return div_1_revenue_1;
	}

	public void setDiv_1_revenue_1(String div_1_revenue_1) {
		this.div_1_revenue_1 = div_1_revenue_1;
	}

	public String getDiv_1_profit_1() {
		return div_1_profit_1;
	}

	public void setDiv_1_profit_1(String div_1_profit_1) {
		this.div_1_profit_1 = div_1_profit_1;
	}

	public String getDiv_1_revenue_2() {
		return div_1_revenue_2;
	}

	public void setDiv_1_revenue_2(String div_1_revenue_2) {
		this.div_1_revenue_2 = div_1_revenue_2;
	}

	public String getDiv_1_profit_2() {
		return div_1_profit_2;
	}

	public void setDiv_1_profit_2(String div_1_profit_2) {
		this.div_1_profit_2 = div_1_profit_2;
	}

	public String getDiv_1_revenue_3() {
		return div_1_revenue_3;
	}

	public void setDiv_1_revenue_3(String div_1_revenue_3) {
		this.div_1_revenue_3 = div_1_revenue_3;
	}

	public String getDiv_1_profit_3() {
		return div_1_profit_3;
	}

	public void setDiv_1_profit_3(String div_1_profit_3) {
		this.div_1_profit_3 = div_1_profit_3;
	}

	public String getDiv_2_revenue_1() {
		return div_2_revenue_1;
	}

	public void setDiv_2_revenue_1(String div_2_revenue_1) {
		this.div_2_revenue_1 = div_2_revenue_1;
	}

	public String getDiv_2_profit_1() {
		return div_2_profit_1;
	}

	public void setDiv_2_profit_1(String div_2_profit_1) {
		this.div_2_profit_1 = div_2_profit_1;
	}

	public String getDiv_2_revenue_2() {
		return div_2_revenue_2;
	}

	public void setDiv_2_revenue_2(String div_2_revenue_2) {
		this.div_2_revenue_2 = div_2_revenue_2;
	}

	public String getDiv_2_profit_2() {
		return div_2_profit_2;
	}

	public void setDiv_2_profit_2(String div_2_profit_2) {
		this.div_2_profit_2 = div_2_profit_2;
	}

	public String getDiv_2_revenue_3() {
		return div_2_revenue_3;
	}

	public void setDiv_2_revenue_3(String div_2_revenue_3) {
		this.div_2_revenue_3 = div_2_revenue_3;
	}

	public String getDiv_2_profit_3() {
		return div_2_profit_3;
	}

	public void setDiv_2_profit_3(String div_2_profit_3) {
		this.div_2_profit_3 = div_2_profit_3;
	}

	public String getDiv_3_revenue_1() {
		return div_3_revenue_1;
	}

	public void setDiv_3_revenue_1(String div_3_revenue_1) {
		this.div_3_revenue_1 = div_3_revenue_1;
	}

	public String getDiv_3_profit_1() {
		return div_3_profit_1;
	}

	public void setDiv_3_profit_1(String div_3_profit_1) {
		this.div_3_profit_1 = div_3_profit_1;
	}

	public String getDiv_3_revenue_2() {
		return div_3_revenue_2;
	}

	public void setDiv_3_revenue_2(String div_3_revenue_2) {
		this.div_3_revenue_2 = div_3_revenue_2;
	}

	public String getDiv_3_profit_2() {
		return div_3_profit_2;
	}

	public void setDiv_3_profit_2(String div_3_profit_2) {
		this.div_3_profit_2 = div_3_profit_2;
	}

	public String getDiv_3_revenue_3() {
		return div_3_revenue_3;
	}

	public void setDiv_3_revenue_3(String div_3_revenue_3) {
		this.div_3_revenue_3 = div_3_revenue_3;
	}

	public String getDiv_3_profit_3() {
		return div_3_profit_3;
	}

	public void setDiv_3_profit_3(String div_3_profit_3) {
		this.div_3_profit_3 = div_3_profit_3;
	}

	public String getDiv_4_revenue_1() {
		return div_4_revenue_1;
	}

	public void setDiv_4_revenue_1(String div_4_revenue_1) {
		this.div_4_revenue_1 = div_4_revenue_1;
	}

	public String getDiv_4_profit_1() {
		return div_4_profit_1;
	}

	public void setDiv_4_profit_1(String div_4_profit_1) {
		this.div_4_profit_1 = div_4_profit_1;
	}

	public String getDiv_4_revenue_2() {
		return div_4_revenue_2;
	}

	public void setDiv_4_revenue_2(String div_4_revenue_2) {
		this.div_4_revenue_2 = div_4_revenue_2;
	}

	public String getDiv_4_profit_2() {
		return div_4_profit_2;
	}

	public void setDiv_4_profit_2(String div_4_profit_2) {
		this.div_4_profit_2 = div_4_profit_2;
	}

	public String getDiv_4_revenue_3() {
		return div_4_revenue_3;
	}

	public void setDiv_4_revenue_3(String div_4_revenue_3) {
		this.div_4_revenue_3 = div_4_revenue_3;
	}

	public String getDiv_4_profit_3() {
		return div_4_profit_3;
	}

	public void setDiv_4_profit_3(String div_4_profit_3) {
		this.div_4_profit_3 = div_4_profit_3;
	}

	public String getDiv_5_revenue_1() {
		return div_5_revenue_1;
	}

	public void setDiv_5_revenue_1(String div_5_revenue_1) {
		this.div_5_revenue_1 = div_5_revenue_1;
	}

	public String getDiv_5_profit_1() {
		return div_5_profit_1;
	}

	public void setDiv_5_profit_1(String div_5_profit_1) {
		this.div_5_profit_1 = div_5_profit_1;
	}

	public String getDiv_5_revenue_2() {
		return div_5_revenue_2;
	}

	public void setDiv_5_revenue_2(String div_5_revenue_2) {
		this.div_5_revenue_2 = div_5_revenue_2;
	}

	public String getDiv_5_profit_2() {
		return div_5_profit_2;
	}

	public void setDiv_5_profit_2(String div_5_profit_2) {
		this.div_5_profit_2 = div_5_profit_2;
	}

	public String getDiv_5_revenue_3() {
		return div_5_revenue_3;
	}

	public void setDiv_5_revenue_3(String div_5_revenue_3) {
		this.div_5_revenue_3 = div_5_revenue_3;
	}

	public String getDiv_5_profit_3() {
		return div_5_profit_3;
	}

	public void setDiv_5_profit_3(String div_5_profit_3) {
		this.div_5_profit_3 = div_5_profit_3;
	}

	public String getDiv_6_revenue_1() {
		return div_6_revenue_1;
	}

	public void setDiv_6_revenue_1(String div_6_revenue_1) {
		this.div_6_revenue_1 = div_6_revenue_1;
	}

	public String getDiv_6_profit_1() {
		return div_6_profit_1;
	}

	public void setDiv_6_profit_1(String div_6_profit_1) {
		this.div_6_profit_1 = div_6_profit_1;
	}

	public String getDiv_6_revenue_2() {
		return div_6_revenue_2;
	}

	public void setDiv_6_revenue_2(String div_6_revenue_2) {
		this.div_6_revenue_2 = div_6_revenue_2;
	}

	public String getDiv_6_profit_2() {
		return div_6_profit_2;
	}

	public void setDiv_6_profit_2(String div_6_profit_2) {
		this.div_6_profit_2 = div_6_profit_2;
	}

	public String getDiv_6_revenue_3() {
		return div_6_revenue_3;
	}

	public void setDiv_6_revenue_3(String div_6_revenue_3) {
		this.div_6_revenue_3 = div_6_revenue_3;
	}

	public String getDiv_6_profit_3() {
		return div_6_profit_3;
	}

	public void setDiv_6_profit_3(String div_6_profit_3) {
		this.div_6_profit_3 = div_6_profit_3;
	}

	public String getDiv_7_revenue_1() {
		return div_7_revenue_1;
	}

	public void setDiv_7_revenue_1(String div_7_revenue_1) {
		this.div_7_revenue_1 = div_7_revenue_1;
	}

	public String getDiv_7_profit_1() {
		return div_7_profit_1;
	}

	public void setDiv_7_profit_1(String div_7_profit_1) {
		this.div_7_profit_1 = div_7_profit_1;
	}

	public String getDiv_7_revenue_2() {
		return div_7_revenue_2;
	}

	public void setDiv_7_revenue_2(String div_7_revenue_2) {
		this.div_7_revenue_2 = div_7_revenue_2;
	}

	public String getDiv_7_profit_2() {
		return div_7_profit_2;
	}

	public void setDiv_7_profit_2(String div_7_profit_2) {
		this.div_7_profit_2 = div_7_profit_2;
	}

	public String getDiv_7_revenue_3() {
		return div_7_revenue_3;
	}

	public void setDiv_7_revenue_3(String div_7_revenue_3) {
		this.div_7_revenue_3 = div_7_revenue_3;
	}

	public String getDiv_7_profit_3() {
		return div_7_profit_3;
	}

	public void setDiv_7_profit_3(String div_7_profit_3) {
		this.div_7_profit_3 = div_7_profit_3;
	}

	public String getDiv_11_revenue_1() {
		return div_11_revenue_1;
	}

	public void setDiv_11_revenue_1(String div_11_revenue_1) {
		this.div_11_revenue_1 = div_11_revenue_1;
	}

	public String getDiv_11_profit_1() {
		return div_11_profit_1;
	}

	public void setDiv_11_profit_1(String div_11_profit_1) {
		this.div_11_profit_1 = div_11_profit_1;
	}

	public String getDiv_11_revenue_2() {
		return div_11_revenue_2;
	}

	public void setDiv_11_revenue_2(String div_11_revenue_2) {
		this.div_11_revenue_2 = div_11_revenue_2;
	}

	public String getDiv_11_profit_2() {
		return div_11_profit_2;
	}

	public void setDiv_11_profit_2(String div_11_profit_2) {
		this.div_11_profit_2 = div_11_profit_2;
	}

	public String getDiv_11_revenue_3() {
		return div_11_revenue_3;
	}

	public void setDiv_11_revenue_3(String div_11_revenue_3) {
		this.div_11_revenue_3 = div_11_revenue_3;
	}

	public String getDiv_11_profit_3() {
		return div_11_profit_3;
	}

	public void setDiv_11_profit_3(String div_11_profit_3) {
		this.div_11_profit_3 = div_11_profit_3;
	}
	
	
	
}
