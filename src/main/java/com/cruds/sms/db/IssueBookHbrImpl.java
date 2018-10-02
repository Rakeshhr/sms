package com.cruds.sms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.sms.util.HibernateUtil;
import com.cruds.sms.entity.Book;
import com.cruds.sms.entity.BookIssue;

@Repository
public class IssueBookHbrImpl implements IssueBookDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean issuebook(String USN, int ISBN) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/YYYY");
		
		String issueDate = sd.format(date);
	
		 Calendar c = Calendar.getInstance();
	     c.setTime(date);
	     c.add(Calendar.DATE, 7);
	     Date retdate = c.getTime();
	     String returnDate = sd.format(retdate);

		BookIssue issue = new BookIssue(USN,ISBN,issueDate,returnDate);
		session.save(issue);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Issue book Method");
		return true;
	}
	
	
	public boolean decrnofobooks(int isbn)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Book where ISBN=:ISBN");
		
		query.setParameter("ISBN", isbn);
		
		Book book = (Book) query.uniqueResult();
		
		int noofcopies = book.getNoOfCopies();
		
		noofcopies = noofcopies-1;
		
		book.setNoOfCopies(noofcopies);
		
		session.save(book);
		
		tx.commit();
		
		session.close();
		
		return true;
	}
	
	public boolean checknoofbooks(int isbn)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Book where ISBN=:ISBN");
		
		query.setParameter("ISBN", isbn);
		
		Book book = (Book) query.uniqueResult();
		
		int noofcopies = book.getNoOfCopies();
		
		if(noofcopies>=1)
		{
			tx.commit();
			
			session.close();
			
			return true;
		}
		else
		{
			tx.commit();
			
			session.close();
			
			return false;
		}
	}
	

}
