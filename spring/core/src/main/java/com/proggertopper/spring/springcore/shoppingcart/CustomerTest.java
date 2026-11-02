package com.proggertopper.spring.springcore.shoppingcart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class CustomerTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/proggertopper/spring/springcore/shoppingcart/myconfig.xml");
		ShoppingCart cart = (ShoppingCart) context.getBean("shoppingcart");
		System.out.println(cart);
	}

}
