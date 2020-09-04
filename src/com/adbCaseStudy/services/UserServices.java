package com.adbCaseStudy.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.adbCaseStudy.dao.UserDao;
import com.adbCaseStudy.entities.Event;
import com.adbCaseStudy.entities.Users;

public class UserServices implements UserDao  {
	
	private final String persistenceUnitName = "adbCaseStudy"; 

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	@Override
	public void addUserEvent(String email,Event event) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 
		Query q = em.createQuery("SELECT u FROM Users u WHERE u.email = :email");
		q.setParameter("email", email); 
		
		Users user = (Users)q.getSingleResult(); 
		user.getUserEvents().add(event);
		
		System.out.println("USER IS BEING DELETED IN ADDUSEREVENT"); 
		
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.close();
		emf.close(); 
	}

	@Override
	public List<Users> getAllUsers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 
		Query q = em.createQuery("SELECT * FROM Users"); 
		List<Users> users = (List<Users>)q.getResultList();
		return users;
	}

	@Override
	public List<Event> getAllUserEvents(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 
		
		Query q = em.createQuery("SELECT e FROM Event e WHERE e.creatorEmail = :email"); 
		q.setParameter("email",email);
		
		List<Event> events = (List<Event>)q.getResultList(); 
		for(Event ele: events) {
			System.out.println(ele.getCreatorEmail());
		}
		return events; 
	}

	@Override
	public Users getUserByEmail(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 
		
		Query q = em.createQuery("SELECT u FROM Users u WHERE u.email = :email"); 
		q.setParameter("email",email);
				
		Users user = (Users)q.getSingleResult();
		return user;
	}

	@Override
	public boolean validateUser(String email, String password) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 	
	
		Query q = em.createQuery("SELECT u FROM Users u WHERE u.email = :email AND u.password = :password"); 
		q.setParameter("email",email);
		q.setParameter("password", password); 
		List<Object> a = q.getResultList();
		
		if(a.isEmpty()) {
			return false;
		}
		
		else {
			return true;
		}
	}

	@Override
	public void deleteEvent(Users user) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 	
		
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		
		em.close();
		emf.close(); 	
	}

	@Override
	public void deleteUser(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName); 
		EntityManager em = emf.createEntityManager(); 	
		
		Query q = em.createQuery("Select u FROM Users u WHERE u.email = :email"); 
		q.setParameter("email", email); 
		
		Users u = (Users)q.getSingleResult();
		
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit(); 
		em.close();
		emf.close(); 
		
		System.out.println("DELETED USER: " + email); 
	}
}
