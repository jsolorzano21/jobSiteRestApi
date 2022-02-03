package com.cdcc.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "project-site-list")
public class ProjectSiteListUsers {

	public String name;
	public boolean admin;
	public boolean editor;
	// Constructors
	public ProjectSiteListUsers() {
	}

	public ProjectSiteListUsers(String name, boolean admin, boolean editor) {
		this.name = name;
		this.admin = admin;
		this.editor = editor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isEditor() {
		return editor;
	}

	public void setEditor(boolean editor) {
		this.editor = editor;
	}
	
}
