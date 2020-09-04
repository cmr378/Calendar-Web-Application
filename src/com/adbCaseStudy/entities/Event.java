package com.adbCaseStudy.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.adbCaseStudy.converter.LocalDateTimeAttributeConverter;

@Entity
public class Event {
	
    @Id @GeneratedValue
	private int id; 
   
	private String title; 
	private String location; 
	private String description;
	private String creatorEmail; 
	
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
    @ManyToMany(mappedBy = "userEvents", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Users> usersInEvent;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(int id, String title, String location, String description,
			LocalDateTime startTime, LocalDateTime endTime, List<Users> usersInEvent,String creatorEmail) {
		super();
		this.id = id;
		this.title = title;
		this.location = location;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.usersInEvent = usersInEvent;
		this.creatorEmail = creatorEmail; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = convertStringToDT(startTime);
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = convertStringToDT(endTime);
	}

	public List<Users> getUsersInEvent() {
		return usersInEvent;
	}

	public void setUsersInEvent(List<Users> usersInEvent) {
		this.usersInEvent = usersInEvent;
	}
	
	public LocalDateTime convertStringToDT(String st) {
	      LocalDateTime ldt = LocalDateTime.parse(st); 
	      return ldt; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((usersInEvent == null) ? 0 : usersInEvent.hashCode());
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
		Event other = (Event) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (usersInEvent == null) {
			if (other.usersInEvent != null)
				return false;
		} else if (!usersInEvent.equals(other.usersInEvent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", location=" + location + ", description=" + description
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", usersInEvent="
				+ usersInEvent + ", creatorEmail=" + creatorEmail + "]";
	}

	public String getCreatorEmail() {
		return creatorEmail;
	}

	public void setCreatorEmail(String creatorEmail) {
		this.creatorEmail = creatorEmail;
	}
}
