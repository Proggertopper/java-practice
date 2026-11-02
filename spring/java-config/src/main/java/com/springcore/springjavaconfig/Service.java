package com.springcore.springjavaconfig;

import org.springframework.beans.factory.annotation.Autowired;

public class Service {
	
	@Autowired
	Dao dao;
	
	public void init() {
		System.out.println("init() method inside");
	}

	public void save() {
		dao.create();
	}
	
	public void destroy() {
		System.out.println("destroy() method inside");
	}
}
