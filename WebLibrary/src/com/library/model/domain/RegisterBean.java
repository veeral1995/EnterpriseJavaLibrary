package com.library.model.domain;

import javax.validation.constraints.Size;

public class RegisterBean {
	@Size(min=1, message= "username is required.")
	private String username;
	
	@Size(min=1, message="password is required.")
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
