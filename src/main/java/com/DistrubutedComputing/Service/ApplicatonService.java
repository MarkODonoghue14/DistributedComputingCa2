package com.DistrubutedComputing.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.DistrubutedComputing.DTO.UserDTO;
import com.DistrubutedComputing.Dao.ApplicationDAO;

@Repository
public class ApplicatonService {
	
	@Autowired 
	ApplicationDAO dao;
	
	public String login(UserDTO user) {
		
		String loginResponse = "";
		
		UserDTO foundUser = dao.findUser(user);
		if(foundUser.getUsername() != null) {
			System.out.print("not valid credentials");
				if (!foundUser.isLoggedIn()) {
					dao.login(foundUser);
					loginResponse = "Login was successful";
				} 
				else {
					loginResponse = "You are already signed in";
				}
		   }				
	    else {
			loginResponse = "Invalid login Credentials";
	     	}
		
		return loginResponse;
	}


	public String logOff(UserDTO user) {
		String logoffResponse = "";
		try {		
		dao.logUserOut(user);		
		logoffResponse ="Logoff was successful";
	}catch(Exception e) {
		e.printStackTrace();
		logoffResponse ="Logoff was unsuccessful";
	}
	return logoffResponse;
	}
}
