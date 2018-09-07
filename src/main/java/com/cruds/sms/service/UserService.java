package com.cruds.sms.service;

import com.cruds.sms.db.UserDAO;
import com.cruds.sms.entity.User;

public class UserService {
	public static boolean createUser(User user)
	{
		UserDAO dao = new UserDAO();
		return dao.createUser(user);
	}
	public static boolean authenticateUser(String firstName,String password)
	{
		UserDAO dao = new UserDAO();
		return dao.authenticateUser(firstName,password);
	}

}
