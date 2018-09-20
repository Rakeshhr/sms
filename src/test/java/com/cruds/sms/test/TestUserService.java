package com.cruds.sms.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cruds.sms.entity.Author;
import com.cruds.sms.entity.Book;
import com.cruds.sms.entity.User;
import com.cruds.sms.service.BookService;
import com.cruds.sms.service.IssueBookService;
import com.cruds.sms.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:sms-servlet.xml"})
public class TestUserService {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private IssueBookService is;

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
		//User user = new User("Sada", "Rud", "sada@gmail.com", "1234", "xyz","dwda"); 
		boolean result = UserService.authenticateUser("Sada", "xyz","dwda");
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
	public void addBook()
	{
		
		Book book = new Book();
		book.setTitle("srfs");
		book.setCategory("sesfs");
		
		Author author = new Author();
		author.setAuthorName("sdsd");
		author.setMailID("aed");
		book.setAuthor(author);
		
		boolean createResult = bookService.create(book);
		
		assertTrue(createResult);
	}
	@Test
	@Ignore
	public void issueBook1()
	{
		//IssueBookService is = new IssueBookService();
		boolean res = is.issue("SMS1",1);
		assertTrue(res);
	}
}
