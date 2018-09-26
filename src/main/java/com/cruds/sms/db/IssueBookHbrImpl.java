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
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/YYYY");
		
		String issueDate = sd.format(date);
		
		//SimpleDateFormat sd1 = new SimpleDateFormat("MM/dd/YYYY");
		//SimpleDateFormat sd2 = new SimpleDateFormat("YYYY");
		
		 Calendar c = Calendar.getInstance();
	     c.setTime(date);
	     c.add(Calendar.DATE, 7);
	     Date retdate = c.getTime();
	     String returnDate = sd.format(retdate);
//		int month = date.getMonth();
//		
//		int my = 7+date.getDate();
//		String returnDate = sd1.format(date) + "/" + my + "/" + sd2.format(date);
		BookIssue issue = new BookIssue(USN,ISBN,issueDate,returnDate);
		session.save(issue);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Issue book Method");
		return true;
	}

	

}
