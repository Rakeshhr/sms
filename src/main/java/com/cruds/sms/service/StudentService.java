package com.cruds.sms.service;

import java.util.List;

import com.cruds.sms.db.StudentDAO;
import com.cruds.sms.entity.Student;

public class StudentService {

	public static boolean create(Student student)
	{
		StudentDAO dao = new StudentDAO();
		return dao.create(student);
	}
	
	public static List<Student> getAllStudents()
	{
		StudentDAO dao = new StudentDAO();
		return dao.getAllStudent();
	}	
	
}
