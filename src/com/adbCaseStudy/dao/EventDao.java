package com.adbCaseStudy.dao;

import java.util.List;

import com.adbCaseStudy.entities.Event;
import com.adbCaseStudy.entities.Users;

public interface EventDao {
	
	//CREATE 
	public void addEvent(Event event);
	public void addUserToEvent(int id,Users user); 
	
	//READ
	public List<Event> getAllEvents(); 
	public List<Users> getAllUsersInEvent(int id); 
	public boolean validateEvent(int id); 
	public List<Event> getAllUserEvents(String email); 
	
	//Update
	public void updateEvent(int id,Event event); 
	public void addUsersInEvent(int id,Users user); 
	
	//Delete
	public void deleteEvent(int id); 
	public void deleteUserFromEvent(int id,String email); 
}
