package com.cdcc.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "financial-results")
public class FinancialDataResults {

	@Id
	public ObjectId _id;

	public String division;
	public String dept_job;
	public String year;
	public String quarter;
	public String job_name;
	public String start_date;
	public String end_date;
	public String contract_amount;
	public String project_cost;
	public String earned_revenue;
	public String earned_revenue_YTD;
	public String bonded;
	public String gross_margin_percent;
	public String backlog;
	public String status;
	public String hit_ratio;

	// Constructors
	public FinancialDataResults() {
	}

	public FinancialDataResults(ObjectId _id, String division, String dept_job,  String year, String quarter, String job_name, String start_date, String end_date, String contract_amount,
			String project_cost, String earned_revenue, String earned_revenue_YTD, String bonded, String gross_margin_percent, String backlog, String status, String hit_ratio) {
		this._id = _id;
		this.division = division;
		this.dept_job = dept_job;
		this.year = year;
		this.quarter = quarter;
		this.job_name = job_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.contract_amount = contract_amount;
		this.project_cost = project_cost;
		this.earned_revenue = earned_revenue;
		this.earned_revenue_YTD = earned_revenue_YTD;
		this.bonded = bonded;
		this.gross_margin_percent = gross_margin_percent;
		this.backlog = backlog;
		this.status = status;
		this.hit_ratio = hit_ratio;
	}

	// ObjectId needs to be converted to string
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getdivision() {
		return division;
	}

	public void setdivision(String division) {
		this.division = division;
	}
	
	public String getdept_job() {
		return dept_job;
	}
	
	public void setdept_job(String dept_job) {
		this.dept_job = dept_job;
	}

	public String getyear() {
		return year;
	}

	public void setyear(String year) {
		this.year = year;
	}

	public String getquarter() {
		return quarter;
	}

	public void setquarter(String quarter) {
		this.quarter = quarter;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getContract_amount() {
		return contract_amount;
	}

	public void setContract_amount(String contract_amount) {
		this.contract_amount = contract_amount;
	}

	public String getProject_cost() {
		return project_cost;
	}

	public void setProject_cost(String project_cost) {
		this.project_cost = project_cost;
	}

	public String getEarned_revenue() {
		return earned_revenue;
	}

	public void setEarned_revenue(String earned_revenue) {
		this.earned_revenue = earned_revenue;
	}

	public String getEarned_revenue_YTD() {
		return earned_revenue_YTD;
	}

	public void setEarned_revenue_YTD(String earned_revenue_YTD) {
		this.earned_revenue_YTD = earned_revenue_YTD;
	}

	public String getBonded() {
		return bonded;
	}

	public void setBonded(String bonded) {
		this.bonded = bonded;
	}

	public String getgross_margin_percent() {
		return gross_margin_percent;
	}

	public void setgross_margin_percent(String gross_margin_percent) {
		this.gross_margin_percent = gross_margin_percent;
	}

	public String getBacklog() {
		return backlog;
	}

	public void setBacklog(String backlog) {
		this.backlog = backlog;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHit_ratio() {
		return hit_ratio;
	}

	public void setHit_ratio(String hit_ratio) {
		this.hit_ratio = hit_ratio;
	}
	
	
}
