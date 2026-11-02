package com.proggertopper.spring.springcore.reftypes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class CustomerTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/proggertopper/spring/springcore/reftypes/reftypesconfig.xml");
		Student student = (Student) context.getBean("student");
		System.out.println(student);
	}

}
