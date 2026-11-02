package com.proggertopper.spring.springcore.constructorinjection.ambiguity;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/proggertopper/spring/springcore/constructorinjection/ambiguity/config.xml");
		Addition employee = (Addition) context.getBean("addition");
		System.out.println(employee);
		
	}
}
