package com.cruds.sms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.sms.entity.Book;

public class BookDAO {
	
	public List<Book> getAllBook()
	{
		String sql = "select ISBN,title,price,category from Book";
		List<Book> list = new ArrayList<>();
		Book s = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				s = new Book(rs.getInt(1), rs.getString(2), rs.getFloat(3),rs.getString(4));
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public boolean create(Book book)
	{
		String sql = "insert into book values(?,?,?,?)";
		int rows =0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getISBN());
			ps.setString(2, book.getTitle());
			ps.setFloat(3, book.getPrice());
			ps.setString(4, book.getCategory());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
		
	}
	
	
	public boolean delete(int ISBN)
	{
		String sql = "delete from book where ISBN=?";
		int rows =0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ISBN);
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
		
	}
}
