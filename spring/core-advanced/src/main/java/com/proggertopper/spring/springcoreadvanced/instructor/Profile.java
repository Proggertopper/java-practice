package com.proggertopper.spring.springcoreadvanced.instructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Profile {

	@Value("Java Architect")
	private String title;
	@Value("Vivekenda Consulting")
	private String company;

	public String getTitle() {
		return title;
	}

	public String getCompany() {
		return company;
	}

	@Override
	public String toString() {
		return "Profile [title=" + title + ", company=" + company + "]";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
