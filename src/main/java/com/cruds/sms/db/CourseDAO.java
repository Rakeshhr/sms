package com.cruds.sms.db;

import java.util.List;

import com.cruds.sms.entity.Course;

public interface CourseDAO {
	
	//public List<Course> getAllCourse();
	public boolean create(Course course);
	public List<Course> getAllCourse();

}
