package com.cruds.sms.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookissue")
public class BookIssue {
	@Id
	@GeneratedValue
	private int issueID;
	@Column
	private String USN;
	@Column
	private String issueDate;
	@Column
	private String returnDate;
	@Column
	private int ISBN;
	public BookIssue(int issueID, String uSN, String issueDate, String returnDate, int iSBN) {
		super();
		this.issueID = issueID;
		USN = uSN;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		ISBN = iSBN;
	}
	public BookIssue() {
		super();
	}
	public int getIssueID() {
		return issueID;
	}
	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}
	public String getUSN() {
		return USN;
	}
	public void setUSN(String uSN) {
		USN = uSN;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	@Override
	public String toString() {
		return "BookIssue [issueID=" + issueID + ", USN=" + USN + ", issueDate=" + issueDate + ", returnDate="
				+ returnDate + ", ISBN=" + ISBN + "]";
	}
	
	
}
