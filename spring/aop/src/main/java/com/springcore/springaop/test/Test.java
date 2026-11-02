package com.springcore.springaop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.springaop.ProductService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/springaop/test/config.xml");

		ProductService productService =(ProductService) context.getBean("productService");
		
		System.out.println(productService.multiply(4, 5));
	}

}
