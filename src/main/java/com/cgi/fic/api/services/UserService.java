package com.cgi.fic.api.services;
import java.util.List;

import com.cgi.fic.api.resources.User;

public interface UserService {

	List<User> getAllUsers();
	
	User getUserByLastName(String lastName);
	
}

