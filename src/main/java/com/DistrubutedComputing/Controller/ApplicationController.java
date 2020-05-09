package com.DistrubutedComputing.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.DistrubutedComputing.DTO.UserDTO;
import com.DistrubutedComputing.Service.ApplicatonService;

@RestController
public class ApplicationController {
	
	
	@Autowired
	ApplicatonService service;

	@RequestMapping(method = RequestMethod.POST, produces="application/json", value="/userlogin")
	@ResponseBody
	public UserDTO login(@RequestBody UserDTO user) {
		UserDTO returnedUser = new UserDTO();
		service.login(user);
		return returnedUser;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces="application/json", value="/user/logoff")
	@ResponseBody
	public String logOff(@RequestBody UserDTO user) {
		return service.logOff(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces="application/json", value="/test")
	@ResponseBody
	public String test() {
		return "HelloWorld";
	}
}


