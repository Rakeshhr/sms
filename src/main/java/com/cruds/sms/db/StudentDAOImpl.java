package com.cruds.sms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		String sql = "insert into student values(?,?)";
		int rows =0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getUSN());
			ps.setString(2, student.getName());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
		
	}
	
	public boolean bulkInsert(List<Student> students)
	{
		String sql = "insert into student values(?,?)";
		int rows =0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			Statement stmt = null;
			
			PreparedStatement ps = conn.prepareStatement(sql);

			for (Student student1: students) {

				ps.setString(1, student1.getUSN());
				ps.setString(2, student1.getName());
				ps.addBatch();
			}
			ps.executeBatch();
			ps.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
		
	}

}
