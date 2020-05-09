package com.DistrubutedComputing.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.DistrubutedComputing.DTO.UserDTO;


@Entity
@Table(name="User")
public class User {
	
	@Id
	@Column(name = "User_Id")
	private int userId;
	
	@Column(name = "Name")
	private String name;
		
	@Column(name = "Username")	
    private String username;
		
    @Column(name = "Password")
    private String password;
		
    @Column(name = "IsLoggedIn")
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
	
	public User() {
		
	}
	
	public User(int userId, String name, String username, String password, boolean isLoggedIn) {
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.isLoggedIn = isLoggedIn;
	}
		
	public User(UserDTO dto) {
		this.userId = dto.getUserId();
		this.name = dto.getName();
		this.username = dto.getUsername();
		this.password = dto.getPassword();
		this.isLoggedIn = dto.isLoggedIn();
	    
	}


}
