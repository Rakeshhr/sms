package com.cruds.sms.db;

import java.util.List;

import com.cruds.sms.entity.FormBean;

public interface SearchDAO {
	
	public List<FormBean> searchBook(String searchKey);

}
