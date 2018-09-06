package com.cruds.sms.service;

import java.util.List;

import com.cruds.sms.db.CourseDAO;
import com.cruds.sms.entity.Course;

public class CourseService {
	
	public static boolean create(Course course)
	{
		CourseDAO dao = new CourseDAO();
		return dao.create(course);
	}
	
	public static List<Course> getAllCourse()
	{
		CourseDAO dao = new CourseDAO();
		return dao.getAllCourse();
	}	
	
	public static boolean delete(int courseid)
	{
		CourseDAO dao = new CourseDAO();
		return dao.delete(courseid);
	}

}
