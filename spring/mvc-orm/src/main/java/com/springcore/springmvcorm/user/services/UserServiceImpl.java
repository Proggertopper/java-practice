package com.springcore.springmvcorm.user.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcore.springmvcorm.user.dao.UserDao;
import com.springcore.springmvcorm.user.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public int save(User user) {
		//some business logic
		return userDao.create(user);
	}

	@Override
	public List<User> getAll() {
		List<User> users = userDao.findAll();//наша бизнес логика
		Collections.sort(users);
		return users;
	}

	@Override
	public User getUser(Integer id) {
		return userDao.findUser(id);
	}

}
