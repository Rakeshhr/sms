package com.cruds.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cruds.sms.entity.Author;
import com.cruds.sms.entity.Book;
import com.cruds.sms.entity.BookIssue;
import com.cruds.sms.entity.Course;
import com.cruds.sms.entity.FormBean;
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
		ModelAndView mv = new ModelAndView("book", "command", new FormBean());
		mv.addObject("BOOKLIST", BookService.getAllBook());
		return mv;
	}
	@RequestMapping(value="/book", method=RequestMethod.POST)
	public String processBookForm(@ModelAttribute("book") FormBean bean)
	{
		
		Book book = new Book();
		book.setISBN(bean.getISBN());
		book.setTitle(bean.getTitle());
		book.setCategory(bean.getCategory());
		Author author = new Author();
		author.setAuthorName(bean.getAuthorName());
		author.setMailID(bean.getMailID());
		author.setBook(book);
		
		bookService.create(book,author);
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
	public String issueBook1(@RequestParam("USN") String usn ,@RequestParam("ISBN") int isbn )
	{
		issueSer.issue(usn,isbn);
		return "redirect:issueBook.html";
	}
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ModelAndView searchBook()
	{
		ModelAndView mv = new ModelAndView("search", "command", new FormBean());
		return mv;
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String searchBook(@RequestParam("searchKey") String key)
	{
		bookService.search(key);
		return "redirect:issueBook.html";
	}
	
	

}
