package com.example.demo.message;

public class AuthenticationRequest {
	
	private String userMail;
	private String userPassword;

	public AuthenticationRequest() {
	}
	public AuthenticationRequest(String userMail, String userPassword) {
		super();
		this.userMail = userMail;
		this.userPassword = userPassword;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

}
