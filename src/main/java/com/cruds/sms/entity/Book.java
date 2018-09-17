package com.cruds.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@SecondaryTable(name="author")
public class Book {
	@Id
	@GeneratedValue
	private int ISBN;
	@Column
	private String title;
	@Column
	private String category;
	
	@Column(table="author")
	private String authorName;
	@Column(table="author")
	private String mailID;
	public Book(int iSBN, String title, String category, String authorName, String mailID) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.category = category;
		this.authorName = authorName;
		this.mailID = mailID;
	}
	
	public Book(int iSBN, String title, String category) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.category = category;
	}

	public Book() {
		super();
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", category=" + category + ", authorName=" + authorName
				+ ", mailID=" + mailID + "]";
	}
	
	
	
	
	
	
	

}
