package com.cruds.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@Column
	private int courseid;
	
	@Column
	private String coursetitle;
	
	@Column
	private String course;
	
	public Course(int courseid, String coursetitle, String course) {
		super();
		this.courseid = courseid;
		this.coursetitle = coursetitle;
		this.course = course;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursetitle() {
		return coursetitle;
	}
	public void setCoursetitle(String coursetitle) {
		this.coursetitle = coursetitle;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Course() {
		super();
	}
	
	
}
