package com.nandadulal.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nandadulal.demo.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	//Fake user list
	List<User> list = Arrays.asList(new User(101,"Nanda",7432),
			                        new User(102,"Ram",6542),
			                        new User(103,"Sam",3434));
	@Override
	public User getUser(int userId) {
		
		//return list.stream().filter(user->user.getUserId()==userId).findAny().orElse(null);
		for(User user : list) {
			if(user.getUserId()==userId) {
				return user;
			}
		}
		return null;
	}

}
