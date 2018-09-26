package com.cruds.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.sms.db.IssueBookDAO;
import com.cruds.sms.db.listissuebookimpl;
/*import com.cruds.sms.db.listissuebookimpl;*/
import com.cruds.sms.entity.BookIssue;

@Service
public class IssueBookService {
	@Autowired
	IssueBookDAO issueDOA;
	public boolean issue(String USN,int ISBN)
	{
		//BookDAOImpl dao = new BookDAOImpl();
		return issueDOA.issuebook(USN,ISBN);
	}
	public List<BookIssue> listissuebook(String Date1,String Date2)
	{
		listissuebookimpl list = new listissuebookimpl();
		return list.listbookissue(Date1, Date2);
	}
}
