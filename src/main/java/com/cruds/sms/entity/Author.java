package com.cruds.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	@Id
	private String authorName;
	@Column
	private String mailID;
	@ManyToOne
	private Book book;
	public Author(String authorName, String mailID, Book book) {
		super();
		this.authorName = authorName;
		this.mailID = mailID;
		this.book = book;
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
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", mailID=" + mailID + ", book=" + book + "]";
	}
	
	
}
