package com.cruds.sms.service;

import java.util.List;

import com.cruds.sms.db.BookDAO;
import com.cruds.sms.entity.Book;



public class BookService {

	
	public static boolean create(Book book)
	{
		BookDAO dao = new BookDAO();
		return dao.create(book);
	}
	
	public static List<Book> getAllBook()
	{
		BookDAO dao = new BookDAO();
		return dao.getAllBook();
	}
	public static boolean delete(int ISBN)
	{
		BookDAO dao = new BookDAO();
		return dao.delete(ISBN);
	}
}
