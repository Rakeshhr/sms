package com.cruds.sms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.sms.entity.Student;

public class StudentDAOImpl {
	
	
	public List<Student> getAllStudent()
	{
		String sql = "select rollno,firstname,lastname from student";
		List<Student> list = new ArrayList<>();
		Student s = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				s = new Student( rs.getString(2), rs.getString(3));
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	public boolean create(Student student)
	{
		String sql = "insert into student values(?,?,?)";
		int rows =0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, student.getRollNo());
			ps.setString(2, student.getFirstName());
			ps.setString(3, student.getLastName());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
		
	}

}
