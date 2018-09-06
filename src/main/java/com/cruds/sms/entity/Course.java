package com.cruds.sms.entity;

public class Course {
	
	
	private int courseid;
	private String coursetitle;
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
