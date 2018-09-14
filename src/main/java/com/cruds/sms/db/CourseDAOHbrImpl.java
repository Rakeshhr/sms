package com.cruds.sms.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.cruds.sms.entity.Course;


@Repository
public class CourseDAOHbrImpl implements CourseDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean create(Course course) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(course);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create Course Method");
		return true;
	}
	
	@Override
	public List<Course> getAllCourse() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		String hql = "FROM Course"; 
		Query query = session.createQuery(hql); 
		List<Course> results = (List<Course>) query.list();


		for(Course d : results)
		{
		System.out.println(d);
		}
		tx.commit();
		session.close();
		return results;
		
	}
	

}
