package com.cruds.sms.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.sms.entity.Author;
import com.cruds.sms.entity.Book;

@Repository
public class BookDAOHbrImpl implements BookDAO{
	
	@Autowired
	SessionFactory sessionFactory;



	@Override
	public boolean create(Book book, Author author) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(author);
		session.save(book);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create book Method");
		return true;
	}
	
	

}
