package com.cruds.sms.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	@Deprecated
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



	@Override
	public boolean create(Book book) {

		
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Author where mailid=:authormailid");
		
		List<Author> listfromexcel = book.getAuthors();
		
		book.setAuthors(new ArrayList<Author>());
		
		for(Author auth : listfromexcel)
		{
			query.setParameter("authormailid",auth.getMailID());
			Author dbAuth = (Author) query.uniqueResult();
			if(dbAuth != null)
			{
				book.addAuthor(dbAuth);
			}
			else
			{
				book.addAuthor(auth);
			}
			
		}
		session.save(book);
		
		tx.commit();
		session.close();
		
		
		return true;
	}
	
		
	
	

}
