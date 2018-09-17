package com.cruds.sms.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.cruds.sms.entity.Book;
import com.cruds.sms.entity.User;
import com.cruds.sms.service.BookService;
import com.cruds.sms.service.UserService;

public class TestUserService {

	@Test
	@Ignore
	public void testCreate() {
		
		User user = new User("Sada", "Rud", "sada@gmail.com", "1234", "xyz","dwda");
		
		boolean result = UserService.createUser(user);
		
		assertTrue(result);
		
	}
	
	@Test
	@Ignore
	public void authenticatePass()
	{
		boolean result = UserService.authenticateUser("Sada", "xyz","rdrrd");
		assertTrue(result);
	}
	
	@Test
	@Ignore
	public void authenticateFail()
	{
		boolean result = UserService.authenticateUser("Sada", "123","gftf");
		assertFalse(result);
	}
	
	@Test
	@Ignore
	public void deletebook()
	{
		Book book = new Book(-111, "Test", "Test",1);
		BookService b1= new BookService();
		boolean createResult = b1.create(book);
		assertTrue(createResult);
		
		boolean result = BookService.delete(-111);
		assertTrue(result);

	}
	
	@Test
	public void addBook()
	{
		Book book = new Book(112,"Test","Test","rame","adasdad");
	
		System.out.println(book);
	}

}
