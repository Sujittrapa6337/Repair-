package com.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LoginBean")
public class LoginBean {
	@Id
	@Column(name="Username")
	private String Username;
	
	@Column(name="Password")
	private String Password;
	
	@Column(name="UserID")
	private String UserID;
	
	public LoginBean(String username, String password) {
		super();
		Username = username;
		Password = password;
	}
	public LoginBean() {
		super();
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	
	
}
