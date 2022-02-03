package com.cdcc.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "project-site-list")
public class ProjectSiteListBody {

	public String siteImage;
	public String siteName;
	public String projectNumber;
	public String siteVisit;
	public String siteEdits;
	public String liveViewUserName;
	public String liveViewPassword;
	public String siteNeedsPublish;
	public List<ProjectSiteListDefault> defaultLinks;
	public List<ProjectSiteListLiveView> liveView;
	public List<ProjectSiteListImageDates> imagePerDate;
	public List<ProjectSiteListUsers> siteUsers;


	// Constructors
	public ProjectSiteListBody() {
	}

	public ProjectSiteListBody(String siteImage, String siteName, String projectNumber, String siteVisit, String siteEdits, String liveViewUserName, String liveViewPassword, String siteNeedsPublish, List<ProjectSiteListDefault> defaultLinks, List<ProjectSiteListLiveView> liveView, List<ProjectSiteListImageDates> imagePerDate, List<ProjectSiteListUsers> siteUsers) {
		this.siteImage = siteImage;
		this.siteName = siteName;
		this.projectNumber = projectNumber;
		this.siteVisit = siteVisit;
		this.siteEdits = siteEdits;
		this.liveViewUserName = liveViewUserName;
		this.liveViewPassword = liveViewPassword;
		this.siteNeedsPublish = siteNeedsPublish;
		this.defaultLinks = defaultLinks;
		this.liveView = liveView;
		this.imagePerDate = imagePerDate;
		this.siteUsers = siteUsers;
	}

	// ObjectId needs to be converted to string
	public String getSiteImage() {
		return siteImage;
	}

	public void setSiteImage(String siteImage) {
		this.siteImage = siteImage;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getSiteVisit() {
		return siteVisit;
	}

	public void setSiteVisit(String siteVisit) {
		this.siteVisit = siteVisit;
	}

	public String getSiteEdits() {
		return siteEdits;
	}

	public void setSiteEdits(String siteEdits) {
		this.siteEdits = siteEdits;
	}

	public String getLiveViewUserName() {
		return liveViewUserName;
	}

	public void setLiveViewUserName(String liveViewUserName) {
		this.liveViewUserName = liveViewUserName;
	}

	public String getLiveViewPassword() {
		return liveViewPassword;
	}

	public void setLiveViewPassword(String liveViewPassword) {
		this.liveViewPassword = liveViewPassword;
	}

	public String getSiteNeedsPublish() {
		return siteNeedsPublish;
	}

	public void setSiteNeedsPublish(String siteNeedsPublish) {
		this.siteNeedsPublish = siteNeedsPublish;
	}

	public List<ProjectSiteListDefault> getDefaultLinks() {
		return defaultLinks;
	}

	public void setDefaultLinks(List<ProjectSiteListDefault> defaultLinks) {
		this.defaultLinks = defaultLinks;
	}

	public List<ProjectSiteListLiveView> getLiveView() {
		return liveView;
	}

	public void setLiveView(List<ProjectSiteListLiveView> liveView) {
		this.liveView = liveView;
	}

	public List<ProjectSiteListImageDates> getImagePerDate() {
		return imagePerDate;
	}

	public void setImagePerDate(List<ProjectSiteListImageDates> imagePerDate) {
		this.imagePerDate = imagePerDate;
	}

	public List<ProjectSiteListUsers> getSiteUsers() {
		return siteUsers;
	}

	public void setSiteUsers(List<ProjectSiteListUsers> siteUsers) {
		this.siteUsers = siteUsers;
	}
	
}
