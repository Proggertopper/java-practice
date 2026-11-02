package com.proggertopper.spring.springcoreadvanced.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	

	
	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}

	@Autowired
    @Qualifier("address123")
	private Address address;

}
