package com.proggertopper.spring.springcore.dependencycheck;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

public class Prescription {
	

	private int id;
	private String name;
	private List<String> medicaments;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Prescription [id=" + id + ", name=" + name + ", medicaments=" + medicaments + "]";
	}

	public List<String> getMedicaments() {
		return medicaments;
	}
	
	@Required
	public void setId(int id) {
		this.id = id;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}
	
	@Required
	public void setMedicaments(List<String> medicaments) {
		this.medicaments = medicaments;
	}

}
