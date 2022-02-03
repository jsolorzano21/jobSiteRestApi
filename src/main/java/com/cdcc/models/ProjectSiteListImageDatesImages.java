package com.cdcc.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "project-site-list")
public class ProjectSiteListImageDatesImages {

	public String imageLink;
	public String imageLabel;
	public String imageDescription;

	// Constructors
	public ProjectSiteListImageDatesImages() {
	}

	public ProjectSiteListImageDatesImages(String imageLink, String imageLabel, String imageDescription) {
		this.imageLink = imageLink;
		this.imageLabel = imageLabel;
		this.imageDescription = imageDescription;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getImageLabel() {
		return imageLabel;
	}

	public void setImageLabel(String imageLabel) {
		this.imageLabel = imageLabel;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}
	
}
