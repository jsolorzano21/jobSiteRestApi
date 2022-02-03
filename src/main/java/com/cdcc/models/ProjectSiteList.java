package com.cdcc.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "project-site-list")
public class ProjectSiteList {

	@Id
	public String id;
	public List<ProjectSiteListBody> production;
	public List<ProjectSiteListBody> development;


	// Constructors
	public ProjectSiteList() {
	}

	public ProjectSiteList(String id, List<ProjectSiteListBody> production, List<ProjectSiteListBody> development) {
		this.id = id;
		this.production = production;
		this.development = development;
		
	}

	// ObjectId needs to be converted to string
	public String getid() {
		return id.toString();
	}

	public void setid(String id) {
		this.id = id;
	}

	public List<ProjectSiteListBody> getProduction() {
		return production;
	}

	public void setProduction(List<ProjectSiteListBody> production) {
		this.production = production;
	}

	public List<ProjectSiteListBody> getDevelopment() {
		return development;
	}

	public void setDevelopment(List<ProjectSiteListBody> development) {
		this.development = development;
	}
	
	
	
}
