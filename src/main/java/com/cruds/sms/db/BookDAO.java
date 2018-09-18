package com.cruds.sms.db;

import com.cruds.sms.entity.Author;
import com.cruds.sms.entity.Book;

public interface BookDAO {

	 public boolean create(Book book,Author author);
	 
	
}
