package com.proggertopper.spring.springcore.ls.interfaces;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Patient implements InitializingBean , DisposableBean{
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("Inside setter method");
		this.id = id;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + "]";
	}

	public void hi() {
		System.out.println("Inside Hi method");
	}
	
	public void bye() {
		System.out.println("Inside Bye method");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Inside destroy()");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside afterPropertiesSet()");
		
	}
	
}
