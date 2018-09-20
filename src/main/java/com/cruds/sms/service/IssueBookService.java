package com.cruds.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.sms.db.IssueBookDAO;

@Service
public class IssueBookService {
	@Autowired
	IssueBookDAO issueDOA;
	public boolean issue(String USN,int ISBN)
	{
		//BookDAOImpl dao = new BookDAOImpl();
		return issueDOA.issuebook(USN,ISBN);
	}
}
