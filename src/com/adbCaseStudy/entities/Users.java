package com.adbCaseStudy.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Users {
	
	@Id
	private String email;
	
	private String password; 
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	 @JoinTable(
	            name = "user_events",
	            joinColumns = {@JoinColumn(name = "email")},
	            inverseJoinColumns = {@JoinColumn(name = "id")}
	    )
	private List<Event> userEvents;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Users(String email, String password, List<Event> userEvents) {
		super();
		this.email = email;
		this.password = password;
		this.userEvents = userEvents;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Event> getUserEvents() {
		return userEvents;
	}

	public void setUserEvents(List<Event> userEvents) {
		this.userEvents = userEvents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userEvents == null) ? 0 : userEvents.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userEvents == null) {
			if (other.userEvents != null)
				return false;
		} else if (!userEvents.equals(other.userEvents))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Users [email=" + email + ", password=" + password + ", userEvents=" + userEvents + "]";
	}
}
