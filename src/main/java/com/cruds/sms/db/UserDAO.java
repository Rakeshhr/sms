package com.cruds.sms.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cruds.sms.entity.User;


public class UserDAO {

	public boolean createUser(User user)
	{
		String sql = "insert into user values(?,?,?,?,?)";
		int rows =0;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3,user.getEmail());
			ps.setString(4, user.getMobNo());
			ps.setString(5, user.getPassword());

			rows = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows > 0;

	}

	public boolean authenticateUser(String firstName,String password ) {
		String sql = "select 1 from user where firstname=? and password=? ";
		boolean found = false;
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,firstName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			//String rsUserName = null;
			//  String rsPassword = null;
			if(rs != null &&  rs.next()){
				found = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return found; 



	}

}