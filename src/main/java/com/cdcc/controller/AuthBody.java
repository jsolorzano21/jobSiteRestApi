package com.cdcc.controller;
public class AuthBody {

    private String email;
    private String password;
    private String adToken;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAdToken() {
    	return adToken;
    }
    public void setAdToken(String adToken) {
    	this.adToken = adToken;
    }


}