package com.cruds.sms.entity;

import javax.persistence.Entity;

@Entity
public class Student {
	
	private String USN;
	private String name;
	public Student(String uSN, String name) {
		super();
		USN = uSN;
		this.name = name;
	}
	public Student() {
		super();
	}
	public String getUSN() {
		return USN;
	}
	public void setUSN(String uSN) {
		USN = uSN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [USN=" + USN + ", name=" + name + "]";
	}
	
	

}
