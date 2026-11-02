package com.proggertopper.spring.springcore.dependencycheck;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/proggertopper/spring/springcore/dependencycheck/config.xml");
		Prescription recipe = (Prescription) context.getBean("recipe");
		System.out.println(recipe);
	}
}
