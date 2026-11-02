package com.springcore.springmvcorm.user.entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User implements Comparable<User> {
	
	@Id
	private Integer id;
	private String name;
	private String email;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	@Override
	public int compareTo(User o) {
		return this.id.compareTo(o.id);
	}

}
