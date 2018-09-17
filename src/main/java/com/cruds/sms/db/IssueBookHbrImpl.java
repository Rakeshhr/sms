package com.cruds.sms.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.sms.entity.BookIssue;



@Repository
public class IssueBookHbrImpl implements IssueBookDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	

	@Override
	public boolean issuebook(BookIssue book) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(book);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Issue book Method");
		return true;
	}

}
