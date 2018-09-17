package com.cruds.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.sms.db.IssueBookDAO;
import com.cruds.sms.entity.BookIssue;

@Service
public class IssueBookService {
	@Autowired
	IssueBookDAO issueDOA;
	public boolean issue(BookIssue book)
	{
		//BookDAOImpl dao = new BookDAOImpl();
		return issueDOA.issuebook(book);
	}
}
