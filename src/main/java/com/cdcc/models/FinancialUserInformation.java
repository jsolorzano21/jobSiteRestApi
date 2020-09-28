package com.cdcc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user-information")
public class FinancialUserInformation {

	@Id
	public String id;
	public String username;
	public String useremail;
	public String userdivision;


	// Constructors
	public FinancialUserInformation() {
	}

	public FinancialUserInformation(String id, String username, String useremail, String userdivision) {
		this.id = id;
		this.username = username;
		this.useremail = useremail;
		this.userdivision = userdivision;
	}

	// ObjectId needs to be converted to string
	public String getid() {
		return id.toString();
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}
	
	public String getuseremail() {
		return useremail;
	}
	
	public void setuseremail(String useremail) {
		this.useremail = useremail;
	}
	
	public String getuserdivision() {
		return userdivision;
	}
	
	public void setuserdivision(String userdivision) {
		this.userdivision = userdivision;
	}
	
}
