package com.nandadulal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nandadulal.demo.model.Contact;
import com.nandadulal.demo.model.User;
import com.nandadulal.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") int userId) {
		
		// call contactService microservice to fetch contact details for user
		
		//http://localhost:9002/contact/user/101
		List<Contact> list  = restTemplate.getForObject("http://contact-service/contact/user/"+userId, List.class);
		// fetch user details from userService microservice
		User user =  service.getUser(userId);
		// set the contacts of the user with the fetched list of contacts from contact service microservice
		user.setContacts(list);
		// return user details with its contact information as well
		return user;
	}
}
