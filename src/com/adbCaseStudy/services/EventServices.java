package com.adbCaseStudy.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.adbCaseStudy.dao.EventDao;
import com.adbCaseStudy.entities.Event;
import com.adbCaseStudy.entities.Users;

public class EventServices implements EventDao {
	
	private final String persistenceUnitName = "adbCaseStudy"; 


	@Override
	public void addEvent(Event event) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 
		
		em.getTransaction().begin();
		em.persist(event);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Override
	public void addUserToEvent(int id,Users user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT e FROM Event e WHERE e.id = :id"); 
		q.setParameter("id",id); 
		
		Event e = (Event)q.getSingleResult(); 
		List<Users> eU = e.getUsersInEvent();
		eU.add(user); 
		e.setUsersInEvent(eU);
		
		em.getTransaction().begin();
		em.merge(e); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public void deleteUserFromEvent(int id,Users user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT e FROM Event e WHERE e.id = :id"); 
		Event e = (Event)q.getSingleResult(); 
		e.getUsersInEvent().remove(user);
		
		deleteEvent(e.getId()); 
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}


	@Override
	public List<Event> getAllEvents() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT * FROM Event"); 
		List<Event> allEvents = (List<Event>)q.getResultList();
		
		em.close();
		emf.close(); 
		return allEvents; 
	}

	@Override
	public List<Users> getAllUsersInEvent(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT * FROM Event"); 		
		
		return null;
	}

	@Override
	public boolean validateEvent(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 
		
		Query q = em.createQuery("SELECT e FROM Event e WHERE e.id = :id"); 
		q.setParameter("id",id);
		List<Object> a = q.getResultList();
		
		if(a.isEmpty()) {
			return false;
		}
		
		else {
			return true;
		}
	}

	@Override
	public void updateEvent(int id, Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUsersInEvent(int id,Users user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT e FROM Event e WHERE e.id = :id"); 
		Event e = (Event)q.getSingleResult(); 
		e.getUsersInEvent().add(user);
		
		deleteEvent(e.getId()); 
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

	@Override
	public void deleteEvent(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 
		
		Query q = em.createQuery("SELECT e FROM Event e WHERE e.id = :id"); 
		q.setParameter("id", id);
		Event e = (Event)q.getSingleResult(); 
		
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		
		em.close();
		emf.close();	
		System.out.println("Event deleted"); 
	}

	@Override
	public void deleteUserFromEvent(int id, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Event> getAllUserEvents(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 
		
		Query q = em.createQuery("SELECT e FROM Event e WHERE e.creatorEmail = :email"); 
		q.setParameter("email", email); 
		
		List<Event> events =(List<Event>) q.getResultList();
		em.close();
		emf.close(); 
		
		return events;
	}
}
