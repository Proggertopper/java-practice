package com.proggertopper.spring.springcore.constructorinjection.ambiguity;

public class Addition {
	
	Addition(int a , double b){
		System.out.println("Inside in Constructor");
		System.out.println(a);
		System.out.println(b);
	}
	
}
