package com.example.demo.dto;


public class UserDto {
	
	public UserDto(Long userId, String userMail, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userMail = userMail;
		this.userName = userName;
		this.userPassword = userPassword;
	}

    public UserDto() {
		
	}

	private Long userId;
	private String userMail;
	private String userName;
	private String userPassword;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userMail=" + userMail + ", userName=" + userName + ", userPassword="
				+ userPassword + "]";
	}
	
	
	
	
	
	

}
