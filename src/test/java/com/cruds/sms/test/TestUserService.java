package com.cruds.sms.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.cruds.sms.entity.Author;
import com.cruds.sms.entity.Book;
import com.cruds.sms.entity.User;
import com.cruds.sms.service.BookService;
import com.cruds.sms.service.IssueBookService;
import com.cruds.sms.service.UserService;

public class TestUserService {

	@Test
	public void testCreate() {
		
		User user = new User("Sada", "Rud", "sada@gmail.com", "1234", "xyz","dwda");
		
		boolean result = UserService.createUser(user);
		
		assertTrue(result);
		
	}
	
	@Test
	public void authenticatePass()
	{
		User user = new User("Sada", "Rud", "sada@gmail.com", "1234", "xyz","dwda"); 
		boolean result = UserService.authenticateUser("Sada", "xyz","dwda");
		assertTrue(result);
	}
	
	@Test
	public void authenticateFail()
	{
		boolean result = UserService.authenticateUser("Sada", "123","gftf");
		assertFalse(result);
	}
	
	
	
	@Test
	public void addBook()
	{
		Book book = new Book();
		book.setTitle("srfs");
		book.setCategory("sesfs");
		
		Author author = new Author();
		author.setAuthorName("sdsd");
		author.setMailID("aed");
		author.setBook(book);
		BookService bookser=new BookService();
		boolean createResult = bookser.create(book,author);
		
		assertTrue(createResult);
	}
	@Test
	public void issueBook1()
	{
		IssueBookService is = new IssueBookService();
		boolean res = is.issue("SMS1",1);
		assertTrue(res);
	}
	

}
