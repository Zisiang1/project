package com.sddevops.project;

import java.util.ArrayList;
import java.util.List;

public class UserCollection {
	private ArrayList<User> users = new ArrayList<>();
	
	public UserCollection() {
    }
    
    
    public List<User> getUser() {
    	return users;
    }
    
   
    public void addUser(User user) {
    	users.add(user);
    }
    
  
    public void deleteUser(User user) {
    	users.remove(user);
    }
    public void getUserByName()
	{
		users.get(0);
	}

}
