package com.cruds.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.sms.db.BookDAO;
import com.cruds.sms.db.BookDAOImpl;
import com.cruds.sms.entity.Book;


@Service
public class BookService {
	@Autowired
	BookDAO bookDAO;

	
	public boolean create(Book book)
	{
		//BookDAOImpl dao = new BookDAOImpl();
		return bookDAO.create(book);
	}
	
	public static List<Book> getAllBook()
	{
		BookDAOImpl dao = new BookDAOImpl();
		return dao.getAllBook();
	}
	public static boolean delete(int ISBN)
	{
		BookDAOImpl dao = new BookDAOImpl();
		return dao.delete(ISBN);
	}
}
