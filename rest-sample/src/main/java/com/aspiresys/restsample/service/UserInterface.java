package com.aspiresys.restsample.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aspiresys.restsample.model.User;

@Service
public class UserInterface implements IUserInterface {

	Map<Integer, User> map = new HashMap<>();

	public User createUser(User user) {

		map.put(user.getUserId(), user);
		return user;

	}

	public Map<Integer, User> getUsers() {
		
		return map;
		
	}

}
