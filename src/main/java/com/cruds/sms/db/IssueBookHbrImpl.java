package com.cruds.sms.db;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	public boolean issuebook(String USN, int ISBN) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/YY");
		String issueDate = sd.format(date);
		SimpleDateFormat sd1 = new SimpleDateFormat("MM/YY");
		int my = 7+date.getDate();
		String returnDate = my + "/" + sd1.format(date);
		BookIssue issue = new BookIssue(USN,issueDate,returnDate,ISBN);
		session.save(issue);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Issue book Method");
		return true;
	}

}
