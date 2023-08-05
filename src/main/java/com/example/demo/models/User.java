package com.example.demo.models;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;

@Builder
@Entity
@Table(name="userTablo")
public class User implements UserDetails{
	
	public User( String userMail, String userName, String userPassword, Role role) {
		super();
		this.userMail = userMail;
		this.userName = userName;
		this.userPassword = userPassword;
		this.role = role;
	}


	public User(Long userId, String userMail, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userMail = userMail;
		this.userName = userName;
		this.userPassword = userPassword;
	}


	// Empty default constructor
    public User() {
    }
	
	


	@Id
	@Column(name="userId", length = 45)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@Column(name="userMail", length = 255)
	private String userMail;
	
	@Column(name="userName", length = 255)
	private String userName;
	
	@Column(name="userPassword", length = 255)
	private String userPassword;
	
	@Enumerated(EnumType.STRING)
	private Role role;

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

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == null) {
            throw new IllegalStateException("User role not set");
        }
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

	@Override
	public String getPassword() {
		return userPassword;
	}

	@Override
	public String getUsername() {
		return userMail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

	

	

	

	

	
	
	
	
	
	
	

}
