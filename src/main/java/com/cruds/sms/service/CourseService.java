package com.cruds.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.sms.db.CourseDAO;
import com.cruds.sms.db.CourseDAOImpl;
import com.cruds.sms.entity.Course;

@Service
public class CourseService {
	
	@Autowired
	CourseDAO courseDAO;
	
	public boolean create(Course course)
	{
		//CourseDAOImpl dao = new CourseDAOImpl();
		return courseDAO.create(course);
	}
	
	public  List<Course> getAllCourse()
	{
		//CourseDAOImpl dao = new CourseDAOImpl();
		return courseDAO.getAllCourse();
	}	
	
	public static boolean delete(int courseid)
	{
		CourseDAOImpl dao = new CourseDAOImpl();
		return dao.delete(courseid);
	}

}
