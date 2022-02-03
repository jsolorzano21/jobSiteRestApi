package com.cdcc.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "project-site-list")
public class ProjectSiteListImageDates {

	public String imageDate;
	public String imageDateFormat;
	public String imageId;
	public List<ProjectSiteListImageDatesImages> images;

	// Constructors
	public ProjectSiteListImageDates() {
	}

	public ProjectSiteListImageDates(String imageDate, String imageDateFormat, String imageId) {
		this.imageDate = imageDate;
		this.imageDateFormat = imageDateFormat;
		this.imageId = imageId;
	}

	public String getImageDate() {
		return imageDate;
	}

	public void setImageDate(String imageDate) {
		this.imageDate = imageDate;
	}

	public String getImageDateFormat() {
		return imageDateFormat;
	}

	public void setImageDateFormat(String imageDateFormat) {
		this.imageDateFormat = imageDateFormat;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	
	
}
