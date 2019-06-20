package com.maocy.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public User() {
		super();
	}
	
	public User(String id) {
		super();
		this.id = id;
	}
	
	public User(String id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	private String id;
	
	private String name;
	
	private Integer age;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
