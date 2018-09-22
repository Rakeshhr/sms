package com.cruds.sms.controller;



import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cruds.sms.db.CourseDAOImpl;
import com.cruds.sms.entity.Author;
import com.cruds.sms.entity.Book;
import com.cruds.sms.entity.BookIssue;

import com.cruds.sms.entity.FormBean;
import com.cruds.sms.entity.Student;
import com.cruds.sms.service.BookService;
import com.cruds.sms.service.IssueBookService;

@Controller
public class HomeController {
	
	public int ISBN;
	public String USN;
	
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
		//book.setISBN(bean.getISBN());
		book.setTitle(bean.getTitle());
		book.setCategory(bean.getCategory());
		Author author = new Author();
		author.setAuthorName(bean.getAuthorName());
		author.setMailID(bean.getMailID());
	
		book.setAuthor(author);
		
		bookService.create(book);
		return "redirect:book.html";
	}
	@RequestMapping(value={"/book1-{ISBN}"}, method=RequestMethod.GET)
	public String storeISBN(@PathVariable("ISBN") int ISBn,HttpSession session)
	{
		session.setAttribute("isbn", ISBn);
		return "redirect:issueBook.html";
	}
	@RequestMapping(value={"/book2-{USN}"}, method=RequestMethod.GET)
	public String storeUSN(@PathVariable("USN") String USn,HttpSession session)
	{
		USN = USn;
		System.out.println(USN);
		session.setAttribute("usn", USn);
		
		return "redirect:issueBook.html";
	}
	
	@RequestMapping(value="/issueBook",method=RequestMethod.GET)
	public ModelAndView issueBook()
	{
		ModelAndView mv = new ModelAndView("issueBook", "command", new BookIssue());
		return mv;
	}
	@RequestMapping(value="/issueBook",method=RequestMethod.POST)
	public String issueBook1(HttpSession session)
	{
		String USN=(String)session.getAttribute("usn");
		System.out.println(USN);
		int ISBN = (Integer)session.getAttribute("isbn");
		System.out.println(ISBN);
		issueSer.issue(USN,ISBN);
		session.removeAttribute("usn");
		session.removeAttribute("isbn");
		return "redirect:issueBook.html";
	}
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String searchBook()
	{
		
		return "search";
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public ModelAndView searchBook(@RequestParam("searchKey") String key)
	{
		CourseDAOImpl dao = new CourseDAOImpl();
		ModelAndView mv = new ModelAndView("search", "command", new FormBean());
		mv.addObject("LIST",dao.search(key));
		return mv;
	}
	@RequestMapping(value="/searchUSN",method=RequestMethod.GET)
	public String searchUSN()
	{
		
		return "issueBook";
	}
	@RequestMapping(value="/searchUSN",method=RequestMethod.POST)
	public ModelAndView searchUSN(@RequestParam("searchKey2") String key)
	{
		CourseDAOImpl dao = new CourseDAOImpl();
		ModelAndView mv = new ModelAndView("issueBook", "command", new Student());
		mv.addObject("LIST1",dao.searchUSN(key));
		return mv;
	}
	@RequestMapping(value="/searchBook",method=RequestMethod.GET)
	public String BookSearch()
	{
		
		return "issueBook";
	}
	
	
	@RequestMapping(value="/searchBook",method=RequestMethod.POST)
	public ModelAndView handleBookSearch(@RequestParam("searchKey1") String key)
	{
		System.out.println("Search==>" + key);
		CourseDAOImpl dao = new CourseDAOImpl();
		ModelAndView mv = new ModelAndView("issueBook", "command", new FormBean());
		mv.addObject("LIST2",dao.searchBook(key));
		return mv;
	}
	
	@RequestMapping(value="/listissuebook",method=RequestMethod.GET)
	public String listissuebook()
	{
		
		return "listissuebook";
		
	}
	
	
	@RequestMapping(value="/listissuebook",method=RequestMethod.POST)
	public ModelAndView listissueBook1(@RequestParam("Date1") String date1,@RequestParam("Date2") String date2)
	{
		IssueBookService ser = new  IssueBookService();
		ModelAndView mv = new ModelAndView("listissuebook", "command", new FormBean());
		mv.addObject("LIST",ser.listissuebook(date1, date2));
		return mv;
	}
	
	

}
