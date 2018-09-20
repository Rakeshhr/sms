package com.cruds.sms.db;

import com.cruds.sms.entity.Author;
import com.cruds.sms.entity.Book;

public interface BookDAO {

	@Deprecated
	 public boolean create(Book book,Author author);
	 public boolean create(Book book);
	 
	
}
