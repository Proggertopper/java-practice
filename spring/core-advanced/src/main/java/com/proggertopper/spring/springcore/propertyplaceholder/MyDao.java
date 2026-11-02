package com.proggertopper.spring.springcore.propertyplaceholder;

public class MyDao {

	private String dbServer;
	private String user;
	
	MyDao(String dbServer , String user){
		this.dbServer = dbServer;
		this.user = user;
	}

	@Override
	public String toString() {
		return "MyDao [dbServer=" + dbServer + ", user=" + user + "]";
	}

	
	
}
