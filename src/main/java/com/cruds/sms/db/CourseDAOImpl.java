package com.cruds.sms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.sms.entity.Course;
import com.cruds.sms.entity.FormBean;

public class CourseDAOImpl {
	

	public List<Course> getAllCourse()
	{
		String sql = "select courseid,coursetitle,course from course";
		List<Course> list = new ArrayList<>();
		Course s = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				s = new Course(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	

	public List<FormBean> search(String key)
	{
		String sql = "select Book.ISBN,Book.title,Book.category,Author.authorName,Author.mailID from Book inner join Author on Book.ISBN=Author.Book_ISBN where title LIKE ? or category LIKE ? or authorName LIKE ?";
		List<FormBean> list = new ArrayList<>();
		FormBean s = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + key + "%");
			ps.setString(2, "%" + key + "%");
			ps.setString(3, "%" + key + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				s = new FormBean(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public boolean create(Course course)
	{
		String sql = "insert into course values(?,?,?)";
		int rows =0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, course.getCourseid());
			ps.setString(2, course.getCoursetitle());
			ps.setString(3, course.getCourse());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
		
	}
	
	public boolean delete(int courseid)
	{
		String sql = "delete from course where courseid=?";
		int rows =0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,courseid);
			
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
		
	}
}
