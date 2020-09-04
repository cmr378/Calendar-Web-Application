package com.adbCaseStudy.controller;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.adbCaseStudy.entities.Event;
import com.adbCaseStudy.entities.Users;
import com.adbCaseStudy.services.EventServices;
import com.adbCaseStudy.services.UserServices;
//session attribute annotation
@Controller
public class MainController {
	
	@RequestMapping(value={"/","/index"})
	public String indexHandler() {
		return "index";  //jsp
	}
	
	@RequestMapping(value="/learn",method=RequestMethod.GET)
	public String learnHandler() {
		return "learn";
	}
	
	/*
	 * User Registration controls
	 */
	
	@RequestMapping(value = {"/create"},method=RequestMethod.GET)
	public ModelAndView createHandler() {
		ModelAndView mv = new ModelAndView(); 
		Users user = new Users(); 
		mv.addObject("user",user); 
		mv.setViewName("/create");
		return mv; 
	} 
	
	@RequestMapping(value = {"/create"},method=RequestMethod.POST)
	public ModelAndView createUser(HttpServletRequest request) {
		
		String email = request.getParameter("email"); 
		String password = request.getParameter("firstPass");
		
		System.out.println("New user entered: " + email + "\nPass: " + password); 
		
		ModelAndView mv = new ModelAndView(); 
		UserServices us = new UserServices(); 
		
		if(us.validateUser(email, password)) {
			mv.setViewName("/error");
			return mv; 
		}
		
		else {
			Users newUser = new Users(email,password,new ArrayList<Event>()); 
			us.addUser(newUser);
			mv.addObject("user", new Users()); 
			mv.setViewName("/calendar");
			return mv; 
		}
	} 
	
	/*
	 * User Registration controls ENDS
	 */
	
	/*
	 * User login controls
	 */
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String displayLogin(Model model) {
		model.addAttribute("user",new Users()); 
		return "login";
	} 
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public ModelAndView loginHandler(HttpSession session,HttpServletRequest request,@ModelAttribute("user")Users user) {
		ModelAndView mv = null; 
		UserServices us = new UserServices(); 
		
		if(us.validateUser(user.getEmail(), user.getPassword())) {
			session.setAttribute("user", user);
			session.setAttribute("email",user.getEmail()); 
			mv = new ModelAndView("calendar");
		}
		else {
			mv = new ModelAndView("login");
		}
		return mv; 
	} 
	
	/*
	 * Logout controllers
	 */
	
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String logoutHandler(HttpSession session,SessionStatus status) {
		status.setComplete(); 
		session.invalidate(); 
		return "index";
	}
	
	/*
	 * Create Event
	 */
	
	@RequestMapping(value = "/createEvent",method=RequestMethod.GET)
	public String displayEvent(Model model) {
		model.addAttribute("event",new Event());
		return "calendar"; 
	}
	
	@RequestMapping(value = "/createEvent",method=RequestMethod.POST)
	public ModelAndView createEvent(HttpSession session,HttpServletRequest request, @ModelAttribute("event")Event event) {
		ModelAndView mv = new ModelAndView(); 
		EventServices es = new EventServices();
		UserServices us = new UserServices(); 
		
		if(es.validateEvent(event.getId())) {
			System.out.println("Event exists already"); 
			mv.setViewName("/calendar");
			return mv;
		}
		else {
			System.out.println("Event doesnt exist already\nCreating event"); 
			System.out.println(event.toString()); 
			event.setCreatorEmail((String)session.getAttribute("email"));
			System.out.println(event.toString()); 
			es.addEvent(event);
			mv.setViewName("/calendar");
			mv.addObject("event",event); 
			return mv; 
		}
	}
	
	@RequestMapping(value="/events",method=RequestMethod.GET)
	public ModelAndView eventsHandler(HttpSession session) {
		ModelAndView mv = new ModelAndView("events"); 
		UserServices us = new UserServices(); 
		List<Event> events = us.getAllUserEvents((String)session.getAttribute("email"));
		mv.addObject("events",events); 
		return mv; 
	}
	
	@RequestMapping(value="/deleteEvent",method=RequestMethod.GET)
	public String deleteEvent(@RequestParam("id") int id,HttpSession session) {
		String email = (String)session.getAttribute("email"); 
		UserServices us = new UserServices(); 
		EventServices es = new EventServices(); 
		Users user = us.getUserByEmail(email);
		System.out.println(user.toString()); 
		es.deleteEvent(id);
		
		for (Iterator<Event> iterator = user.getUserEvents().iterator(); iterator.hasNext(); ) {
		    Event value = iterator.next();
		    if (value.getId() == id) {
		        iterator.remove();
		    }
		}
		user.setUserEvents(new EventServices().getAllUserEvents(email));
		System.out.println(user.toString()); 
		session.setAttribute("events",user.getUserEvents()); 
		return "events"; 
	}
}
