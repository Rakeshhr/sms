package com.cruds.sms.db;

import java.util.List;

import com.cruds.sms.entity.BookIssue;

public interface IssueBookDAO {
	
	public boolean issuebook(String USN,int ISBN);
}
