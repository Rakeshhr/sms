package com.cruds.sms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cruds.sms.entity.FormBean;
import com.cruds.sms.service.BookService;

public class Test {
	@Autowired
	private BookService bookService;

	public void main(String[] args) {
			
		List<FormBean> res = new ArrayList<>();
			res=bookService.search("Java");
		for( FormBean f:res)
		{
			System.out.println(f.getISBN());
			System.out.println(f.getCategory());
		}
	}

}
