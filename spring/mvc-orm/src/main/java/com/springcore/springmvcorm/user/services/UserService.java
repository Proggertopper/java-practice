package com.springcore.springmvcorm.user.services;

import java.util.List;

import com.springcore.springmvcorm.user.entity.User;

public interface UserService {

	int save(User user);
	
	List<User> getAll();
	
	User getUser(Integer id);
}
