package com.maocy.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public User(String id) {
		super();
		this.id = id;
	}

	private String id;

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}
}
