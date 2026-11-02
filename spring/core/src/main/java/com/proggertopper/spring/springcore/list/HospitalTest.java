package com.proggertopper.spring.springcore.list;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class HospitalTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/proggertopper/spring/springcore/list/listconfig.xml");
		Hospital hospital = (Hospital) context.getBean("hospital");
		System.out.println("Hospital name is " + hospital.getName());
		System.out.println("There are some departments " + hospital.getDepartments());
	}

}
