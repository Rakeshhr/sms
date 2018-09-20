package com.cruds.sms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	
	@Id
	@GeneratedValue
	@Column(name="auth_id")
	private Long auth_id;
	
	@Column
	private String authorName;
	
	@Column
	private String mailID;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="author")
	private List<Book> books;
	
	public Author(String authorName, String mailID) {
		super();
		this.authorName = authorName;
		this.mailID = mailID;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getMailID() {
		return mailID;
	}
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}

	
	public Long getAuth_id() {
		return auth_id;
	}
	public void setAuth_id(Long auth_id) {
		this.auth_id = auth_id;
	}
	
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", mailID=" + mailID + "]";
	}
	
	
}
