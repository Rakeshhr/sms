package com.cruds.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cruds.sms.entity.Book;

import com.cruds.sms.service.BookService;


@Controller
public class BookController {
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
		System.out.println(book.getISBN() + ":" + book.getTitle() + ":" + book.getPrice() + ":" + book.getCategory());
		BookService.create(book);
		return "redirect:book.html";
	}
	
	@RequestMapping(value={"/bookdel-{ISBN}"}, method=RequestMethod.GET)
	public String deleteBookForm(@PathVariable("ISBN") int ISBN)
	{
		//System.out.println(book.getISBN() + ":" + book.getTitle() + ":" + book.getPrice() + ":" + book.getCategory());
		System.out.println("HII" + ISBN);
		BookService.delete(ISBN);
		return "redirect:book.html";
	}
	
	
	

}
