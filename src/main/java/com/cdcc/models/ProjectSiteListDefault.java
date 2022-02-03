package com.cdcc.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "project-site-list")
public class ProjectSiteListDefault {

	public String pathname;
	public String name;
	public String editorState;
	public String editorStateDescription;
	public String rawMessage;

	// Constructors
	public ProjectSiteListDefault() {
	}

	public ProjectSiteListDefault(String pathname, String name, String editorState, String editorStateDescription, String rawMessage) {
		this.pathname = pathname;
		this.name = name;
		this.editorState = editorState;
		this.editorStateDescription = editorStateDescription;
		this.rawMessage = rawMessage;
	}

	public String getPathname() {
		return pathname;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEditorState() {
		return editorState;
	}

	public void setEditorState(String editorState) {
		this.editorState = editorState;
	}

	public String getEditorStateDescription() {
		return editorStateDescription;
	}

	public void setEditorStateDescription(String editorStateDescription) {
		this.editorStateDescription = editorStateDescription;
	}

	public String getRawMessage() {
		return rawMessage;
	}

	public void setRawMessage(String rawMessage) {
		this.rawMessage = rawMessage;
	}
	
	
}
