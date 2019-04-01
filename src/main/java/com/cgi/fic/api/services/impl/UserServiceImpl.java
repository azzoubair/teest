package com.cgi.fic.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.fic.api.data.UserData;
import com.cgi.fic.api.resources.User;
import com.cgi.fic.api.services.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserData usrData;
	
	
	@Override
	public List<User> getAllUsers() {
		return usrData.getUsers();
	}


	@Override
	public User getUserByLastName(String lastName) {
		for (User user : usrData.getUsers()) {
			if (user.getLastName().equalsIgnoreCase(lastName)) {
				return user;
			}
		}
		return null;
	}

}

