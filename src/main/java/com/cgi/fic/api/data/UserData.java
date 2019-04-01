package com.cgi.fic.api.data;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.cgi.fic.api.resources.User;

@Component
public class UserData {
	
	private List<User> users = new ArrayList<User>();

	public UserData() {
		User usr1 = new User();
		usr1.setFirstName("Luke");
		usr1.setLastName("Skywalker");
		usr1.setUserId("azzoubair");
		users.add(usr1);
		
		User usr2 = new User();
		usr2.setFirstName("Dark");
		usr2.setLastName("Vador");
		users.add(usr2);
	}

	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}

