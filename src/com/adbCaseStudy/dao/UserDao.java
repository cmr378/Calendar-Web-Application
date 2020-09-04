package com.adbCaseStudy.dao;

import java.util.List;

import com.adbCaseStudy.entities.Event;
import com.adbCaseStudy.entities.Users;

public interface UserDao {
	//CREATE
	public void addUser(Users user); 
	public void addUserEvent(String email,Event event);
	
	//READ
	public List<Users> getAllUsers(); 
	public List<Event> getAllUserEvents(String email); 
	public Users getUserByEmail(String email);
	public boolean validateUser(String email,String password); 
	
	//Update
	public void deleteEvent(Users user);
	
	//Delete
	public void deleteUser(String email);
}
