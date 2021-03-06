package com.cruds.sms.controller;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cruds.sms.db.BookDAOHbrImpl;
import com.cruds.sms.db.BookDAOImpl;
import com.cruds.sms.db.CourseDAOImpl;
import com.cruds.sms.db.ExcelHelper;
import com.cruds.sms.db.IssueBookHbrImpl;
import com.cruds.sms.db.StudentDAOImpl;
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
		List<Author> authors = new ArrayList<>();
		Author author = new Author();
		author.setAuthorName(bean.getAuthorName());
		author.setMailID(bean.getMailID());
	    authors.add(author);
		book.setAuthors(authors);
		
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
	public String issueBook1(HttpSession session,RedirectAttributes redirectAttributes)
	{
		String USN=(String)session.getAttribute("usn");
		System.out.println(USN);
		int ISBN = (Integer)session.getAttribute("isbn");
		System.out.println(ISBN);
		IssueBookHbrImpl dao = new IssueBookHbrImpl();
		boolean check = dao.checknoofbooks(ISBN);
		if(check)
		{
		issueSer.issue(USN,ISBN);
		dao.decrnofobooks(ISBN);
		session.removeAttribute("usn");
		session.removeAttribute("isbn");
		return "redirect:issueBook.html";
		}
		else
		{
			redirectAttributes.addAttribute("errorMessage", "Invalid IssueBook");
			return "redirect:issueBook.html";
		}
		
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
	public ModelAndView listissueBook1(@RequestParam("Date1") Date date1,@RequestParam("Date2") Date date2)
	{
		IssueBookService ser = new  IssueBookService();
		SimpleDateFormat sd1 = new SimpleDateFormat("MM/dd/YYYY");
		SimpleDateFormat sd2 = new SimpleDateFormat("MM/dd/YYYY");
		String d1 = sd1.format(date1);
		String d2 = sd2.format(date2);
		ModelAndView mv = new ModelAndView("listissuebook", "command", new BookIssue());
		mv.addObject("LISTISSUEBOOK",ser.listissuebook(d1, d2));
		return mv;
	}
	
	@RequestMapping(value="/readexcel",method=RequestMethod.GET)
	public String readexcel()
	{
		
		return "readexcel";
		
	}
	
//	@RequestMapping(value="/readexcel",method=RequestMethod.POST)
//	public String addbookexcel(@RequestParam("myFile") MultipartFile file)
//	{
//		StudentDAOImpl dao = new StudentDAOImpl();
//		
//		ExcelHelper exe = new ExcelHelper();
//		List<Student> students = exe.addBook(file);
//		for(Student student : students)
//		{
//			dao.create(student);
//		}
//		return "redirect:readexcel.html";
//	}
	
	@RequestMapping(value="/readexcel",method=RequestMethod.POST)
	public String bulkinsert(@RequestParam("myFile") MultipartFile file)
	{
		StudentDAOImpl dao = new StudentDAOImpl();
		
		ExcelHelper exe = new ExcelHelper();
		List<Student> students = exe.addBook(file);
		dao.bulkInsert(students);
		return "redirect:readexcel.html";
	}
	
	@RequestMapping(value="/bulkbookissue",method=RequestMethod.GET)
	public String bulkbookissue()
	{
		
		return "bulkbookissue";
		
	}
	
	@RequestMapping(value="/bulkbookissue",method=RequestMethod.POST)
	public String bulkbookissue1(@RequestParam("myFile") MultipartFile file)
	{
		BookDAOImpl dao = new BookDAOImpl();
		
		ExcelHelper exe = new ExcelHelper();
		List<Book> book = exe.helper(file);
		dao.createBulk(book);
		return "redirect:bulkbookissue.html";
	}
	
	

}
