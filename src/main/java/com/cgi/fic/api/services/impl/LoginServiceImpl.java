package com.cgi.fic.api.services.impl;

import org.springframework.stereotype.Service;

import com.cgi.fic.api.resources.User;
import com.cgi.fic.api.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public User checkLogin(User user) {
		if (user==null) {
			return null;	
		} 
		
		if ("dvador".equalsIgnoreCase(user.getUserId()) &&
				"motdepasse".equalsIgnoreCase(user.getPassword())) {
			user.setFirstName("Dark");
			user.setLastName("Vador");
			return user;
		} else {
			return user;
		}
		
	}
}

