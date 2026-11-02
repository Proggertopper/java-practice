package com.proggertopper.spring.springcore.innerbeans;

public class Employee {
	
	private int id;
	public int getId() {
		return id;
	}
	public Address getAddress() {
		return address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	private Address address;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", address=" + address + "]";
	}

}
