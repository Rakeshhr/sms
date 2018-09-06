package com.cruds.sms.entity;



public class Book {
	
	private int ISBN;
	private String title;
	private float price;
	private String category;
	
	
	public Book(int iSBN, String title, float price, String category) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.price = price;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
