package com.proggertopper.spring.springcore.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContriesAndLanguagesTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/proggertopper/spring/springcore/properties/propconfig.xml");
		ContriesAndLanguages languages = (ContriesAndLanguages)context.getBean("contriesandlanguages");
		System.out.println(languages.getClass().getName());

	}

}
