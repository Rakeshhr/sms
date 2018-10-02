package com.cruds.sms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

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
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Author> authors = new ArrayList<Author>();
	
	@Column
	private int noOfCopies;
	
	
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
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	
	
	public int getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", category=" + category + ", authors=" + authors + "]";
	}
	

	public void addAuthor(Author author)
	{
		authors.add(author);
		
	}
	
	
}
