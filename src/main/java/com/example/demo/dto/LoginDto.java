package com.example.demo.dto;

public class LoginDto {
	
	public LoginDto() {
		}
	public LoginDto(String userMail, String userPassword) {
		super();
		this.userMail = userMail;
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "LoginDto [userMail=" + userMail + ", userPassword=" + userPassword + "]";
	}
	private String userMail;
	private String userPassword;
	
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
