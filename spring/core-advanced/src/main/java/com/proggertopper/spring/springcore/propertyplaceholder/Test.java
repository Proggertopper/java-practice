package com.proggertopper.spring.springcore.propertyplaceholder;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/proggertopper/spring/springcore/propertyplaceholder/config.xml");
		MyDao recipe = (MyDao) context.getBean("mydao");
		System.out.println(recipe);
	}
}
