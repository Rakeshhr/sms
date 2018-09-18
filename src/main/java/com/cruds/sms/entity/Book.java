package com.cruds.sms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue
	private int ISBN;
	@Column
	private String title;
	@Column
	private String category;
	@OneToMany(targetEntity=Author.class,mappedBy="book",cascade=CascadeType.ALL)
	private List<Author> author;
	
	public Book(int iSBN, String title, String category, List<Author> author) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.category = category;
		this.author = author;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public List<Author> getAuthor() {
		return author;
	}
	public void setAuthor(List<Author> author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", category=" + category + ", author=" + author + "]";
	}
	
	
}
