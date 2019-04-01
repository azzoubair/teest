package com.cgi.fic.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.fic.api.resources.User;
import com.cgi.fic.api.services.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
		
	@RequestMapping(value="/login" ,method = RequestMethod.POST,  produces="application/json; charset=utf-8")
	public User checkLogin(@RequestBody User user) {
		   return loginService.checkLogin(user);
	}

}
