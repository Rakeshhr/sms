package com.cruds.sms.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.cruds.sms.entity.User;
import com.cruds.sms.service.UserService;

public class TestUserService {

	@Test
	@Ignore
	public void testCreate() {
		
		User user = new User("Sada", "Rud", "sada@gmail.com", "1234", "xyz");
		
		boolean result = UserService.createUser(user);
		
		assertTrue(result);
		
	}
	
	@Test
	public void authenticatePass()
	{
		boolean result = UserService.authenticateUser("Sada", "xyz");
		assertTrue(result);
	}
	
	@Test
	public void authenticateFail()
	{
		boolean result = UserService.authenticateUser("Sada", "123");
		assertFalse(result);
	}	

}
