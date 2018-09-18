package com.cruds.sms.entity;


public class FormBean {

	private int ISBN;
	private String title;
	private String category;
	private String authorName;
	private String mailID;
	public FormBean(int iSBN, String title, String category, String authorName, String mailID) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.category = category;
		this.authorName = authorName;
		this.mailID = mailID;
	}
	public FormBean() {
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
		return "FormBean [ISBN=" + ISBN + ", title=" + title + ", category=" + category + ", authorName=" + authorName
				+ ", mailID=" + mailID + "]";
	}
	
	
}
