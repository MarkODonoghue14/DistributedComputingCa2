package com.DistrubutedComputing.DTO;

import javax.persistence.Column;
import javax.persistence.Id;

import com.DistrubutedComputing.Entity.User;

public class UserDTO {
	
	private int userId;

	private String name;
		
    private String username;
		
    private String password;
		
    private boolean isLoggedIn;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	public UserDTO() {
		
	}
	
	public UserDTO(int userId, String name, String username, String password,
			boolean isLoggedIn) {
	this.userId = userId;
	this.name = name;
	this.username = username;
	this.password = password;
	this.isLoggedIn = isLoggedIn;
	}
	
	public UserDTO(String username,String password) {
		this.username  = username;
		this.password = password;
	}
	
	public UserDTO(User user) {
		this.userId = user.getUserId();
		this.name = user.getName();
		this.username = user.getUsername();
		this.password = user.getPassword();
        this.isLoggedIn = user.isLoggedIn();	
	}

}
