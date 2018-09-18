package com.cruds.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.sms.db.BookDAO;
import com.cruds.sms.db.BookDAOImpl;
import com.cruds.sms.db.SearchDAO;
import com.cruds.sms.entity.Author;
import com.cruds.sms.entity.Book;
import com.cruds.sms.entity.FormBean;


@Service
public class BookService {
	@Autowired
	BookDAO bookDAO;
	
	@Autowired
	SearchDAO searchDAO;
	
	public boolean create(Book book,Author author)
	{
		//BookDAOImpl dao = new BookDAOImpl();
		return bookDAO.create(book,author);
	}
	
	public static List<FormBean> getAllBook()
	{
		BookDAOImpl dao = new BookDAOImpl();
		return dao.getAllBook();
	}
	public static boolean delete(int ISBN)
	{
		BookDAOImpl dao = new BookDAOImpl();
		return dao.delete(ISBN);
	}
	public List<FormBean> search(String key)
	{
		return searchDAO.searchBook(key); 
	}
	
}
