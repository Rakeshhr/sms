package com.cruds.sms.service;

import java.util.List;

import com.cruds.sms.db.StudentDAOImpl;
import com.cruds.sms.entity.Student;

public class StudentService {

//	public static boolean create(Student student)
//	{
//		StudentDAOImpl dao = new StudentDAOImpl();
//		return dao.create(student);
//	}
	
	public static List<Student> getAllStudents()
	{
		StudentDAOImpl dao = new StudentDAOImpl();
		return dao.getAllStudent();
	}	
	
}
