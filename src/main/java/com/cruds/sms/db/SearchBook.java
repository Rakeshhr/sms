package com.cruds.sms.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.sms.entity.FormBean;


@Repository
public class SearchBook implements SearchDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<FormBean> searchBook(String searchKey) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "select Book.ISBN,Book.title,Book.category,Author.authorName,Author.mailID from Book inner join Author on Book.ISBN=Author.Book_ISBN where title LIKE ? or category LIKE ? or authorName LIKE ?";
		
		Query query = session.createSQLQuery(hql);
		query.setString(0, "%"+searchKey+"%");
		query.setString(1, "%"+searchKey+"%");
		query.setString(2, "%"+searchKey+"%");
		List<FormBean> res = query.list();
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create book Method");
		return res;
	}

}
