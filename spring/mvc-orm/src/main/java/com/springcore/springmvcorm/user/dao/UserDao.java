package com.springcore.springmvcorm.user.dao;

import java.util.List;

import com.springcore.springmvcorm.user.entity.User;

public interface UserDao {
	
	int create(User user);
	
	List<User> findAll();
	
	User findUser(Integer id);
}
