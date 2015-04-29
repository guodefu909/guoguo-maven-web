package com.domain;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = -4158372353139084044L;

	private int id;

	private String name;

	private boolean status;

	public Person(){
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int id,String name){
		super();
		this.id = id;
		this.name = name;
	}

	public Person(int id,String name,boolean status){
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


}
