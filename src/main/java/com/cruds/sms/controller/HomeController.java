package com.cruds.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cruds.sms.entity.Book;
import com.cruds.sms.entity.BookIssue;
import com.cruds.sms.entity.Course;
import com.cruds.sms.service.BookService;
import com.cruds.sms.service.IssueBookService;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private IssueBookService issueSer;
	
	@RequestMapping(value="/book", method=RequestMethod.GET)
	public ModelAndView showBookForm()
	{
		System.out.println("Inside Show Book FOrm GET");
		ModelAndView mv = new ModelAndView("book", "command", new Book());
		mv.addObject("BOOKLIST", BookService.getAllBook());
		return mv;
	}
	@RequestMapping(value="/book", method=RequestMethod.POST)
	public String processBookForm(@ModelAttribute("book") Book book)
	{
		//System.out.println(book.getISBN() + ":" + book.getTitle() + ":" + book.getPrice() + ":" + book.getCategory());
		bookService.create(book);
		return "redirect:book.html";
	}
//	@RequestMapping(value={"/bookdel-{ISBN}"}, method=RequestMethod.GET)
//	public String deleteBookForm(@PathVariable("ISBN") int ISBN)
//	{
//		//System.out.println(book.getISBN() + ":" + book.getTitle() + ":" + book.getPrice() + ":" + book.getCategory());
//		System.out.println("HII" + ISBN);
//		BookService.delete(ISBN);
//		return "redirect:addBook.html";
//	}
	
	@RequestMapping(value="/issueBook",method=RequestMethod.GET)
	public ModelAndView issueBook()
	{
		ModelAndView mv = new ModelAndView("issueBook", "command", new BookIssue());
		return mv;
	}
	@RequestMapping(value="/issueBook",method=RequestMethod.POST)
	public String issueBook1(@ModelAttribute("issueBook") BookIssue issuebook)
	{
		issueSer.issue(issuebook);
		return "redirect:issueBook.html";
	}
	
	

}
