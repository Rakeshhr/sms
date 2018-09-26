package com.cruds.sms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.sms.entity.BookIssue;

public class listissuebookimpl {
	
	public List<BookIssue> listbookissue(String Date1, String Date2) {
		
		String sql = "select * from BookIssue where returnDate >=? and returnDate <=?";
		List<BookIssue> list = new ArrayList<>();
		BookIssue s = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Date1);
			ps.setString(2, Date2);
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				s = new BookIssue(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	
}

}
