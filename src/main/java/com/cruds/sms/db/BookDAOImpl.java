package com.cruds.sms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.sms.entity.Book;

public class BookDAOImpl {
	
	public List<Book> getAllBook()
	{
		String sql = "select Book.ISBN,Book.category,Book.title,Author.authorName,Author.mailID from Book inner join Author where Book.ISBN=Author.ISBN";
		List<Book> list = new ArrayList<>();
		Book s = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				s = new Book(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public boolean create(Book book)
	{
		String sql = "insert into book values(?,?,?,?,?,?)";
		int rows =0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getISBN());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getCategory());
			ps.setString(4, book.getAuthorName());
			ps.setString(5, book.getMailID());
			
			
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
