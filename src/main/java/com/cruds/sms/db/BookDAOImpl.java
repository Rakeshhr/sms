package com.cruds.sms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cruds.sms.util.HibernateUtil;
import com.cruds.sms.entity.Author;
import com.cruds.sms.entity.Book;
import com.cruds.sms.entity.FormBean;

public class BookDAOImpl {
	
	public List<FormBean> getAllBook()
	{
		String sql = "select b.ISBN,b.category,b.title,a.authorName,a.mailID from Book b,Author a,book_author ba where b.isbn = ba.books_isbn and a.auth_id = ba.authors_auth_id";
		List<FormBean> list = new ArrayList<>();
		FormBean s = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				s = new FormBean(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public boolean create(Book book)
	{
		String sql = "insert into book values(?,?,?)";
		int rows =0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getISBN());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getCategory());
			
			
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
		
	}
	
	
	public boolean delete(int ISBN)
	{
		String sql = "delete from book where ISBN=?";
		int rows =0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ISBN);
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
		
	}
	
	
	
	public void createBulk(List<Book> bookList) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Author where mailid=:mailid");
		
		
		for(Book book : bookList)
		{
			List<Author> listfromexcel = book.getAuthors();
			
			book.setAuthors(new ArrayList<Author>());
			
			for(Author auth : listfromexcel)
			{
				query.setParameter("mailid",auth.getMailID());
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
		}
		
		tx.commit();
		session.close();
		
		
	}
	
	
}
