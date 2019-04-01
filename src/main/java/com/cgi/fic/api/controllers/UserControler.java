package com.cgi.fic.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cgi.fic.api.exceptions.ErrorResource;
import com.cgi.fic.api.exceptions.FicApiException;
import com.cgi.fic.api.resources.User;
import com.cgi.fic.api.services.UserService;

@RestController
public class UserControler {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users",method = RequestMethod.GET,  produces="application/json; charset=utf-8")
    public List<User> allUsers() {
		List<User> user =  userService.getAllUsers();
    	if (user == null) {
    		
			throw new FicApiException(new ErrorResource("error.users.notFound", "Il n y aucun utilisateur", HttpStatus.OK));
    	}
        return userService.getAllUsers();
    }
	
	
	
	@RequestMapping(value="/user",method = RequestMethod.GET,  produces="application/json; charset=utf-8")
    public User getUserByLastName(@RequestParam(value="name") String name) {
    	User user =  userService.getUserByLastName(name);
    	if (user == null) {
    		throw new FicApiException(new ErrorResource("error.users.notFound", name, HttpStatus.OK));
    	}
    	return user;
    }
	
	 
	@RequestMapping(value="/users/{lastName}",method = RequestMethod.GET,  produces="application/json; charset=utf-8")
    public User getUserByLastNameInPath(@PathVariable(value="lastName") String name) {
		User user =  userService.getUserByLastName(name);
    	if (user == null) {
    		throw new FicApiException(new ErrorResource("error.users.notFound", name, HttpStatus.OK));
    	}
    	return userService.getUserByLastName(name);
    }

	
	
}

