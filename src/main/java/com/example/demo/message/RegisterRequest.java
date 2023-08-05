package com.example.demo.message;

import com.example.demo.models.Role;

public class RegisterRequest {
	
	private String userMail;
	private String userName;
	private String userPassword;
	 private Role role;
	
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public RegisterRequest(String userMail, String userName, String userPassword, Role role) {
		super();
		this.userMail = userMail;
		this.userName = userName;
		this.userPassword = userPassword;
		this.role = role;
	}
	public RegisterRequest() {
	}
	
	
	

}
