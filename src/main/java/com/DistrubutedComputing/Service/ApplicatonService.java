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
		try {
		List <UserDTO> userList =  dao.login(user);
      for (UserDTO returnedUser : userList) {
			if (returnedUser.getUsername().equals(user.getUsername())) {
				System.out.print("correct username");
				if (returnedUser.getPassword().equals(user.getPassword())) {
					System.out.print("username and password are correct");
					if (!returnedUser.isLoggedIn()) {
						dao.logUserIn(returnedUser);
						loginResponse = "Successful Login";
					} else {
						loginResponse = "Sorry the user is already logged in";
					}
				} else {
					loginResponse = "The password isn't correct";
				}
			} else {
				loginResponse = "No such user registered ";
			}	
		}

	} catch (Exception e) {
		e.printStackTrace();
		loginResponse = "Error Logiing in User";
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
