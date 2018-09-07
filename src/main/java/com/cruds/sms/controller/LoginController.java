package com.cruds.sms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cruds.sms.entity.Book;
import com.cruds.sms.entity.User;
import com.cruds.sms.service.BookService;
import com.cruds.sms.service.UserService;
@Controller
public class LoginController {
	
	@RequestMapping(value="/login")
	public String redirecttoLogin()
	{
		return "login";
	}
	
	@RequestMapping(value="/checklogin")
	public String checkLogin(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		
			boolean check = UserService.authenticateUser(username, password);
			if(check)
			{
				return "home";
			}
			else
			{
				return "login";
			}
		
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET) 
	public String displayLogin(Model model) { 
	    model.addAttribute("user", new User()); 
	    return "signup"; 
	}
	

	
	
	@RequestMapping(value="/createuser", method = RequestMethod.POST)
	public String createUserPage(@ModelAttribute("user") User user)
	{
		UserService.createUser(user);
		return "redirect:login.html";
	}

}
