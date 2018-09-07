package com.cruds.sms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cruds.sms.entity.User;

import com.cruds.sms.service.UserService;
@Controller
@SessionAttributes("USER")
public class LoginController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String redirecttoLogin()
	{
		return "login";
	}
	
	@RequestMapping(value="/checklogin",method=RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username,@RequestParam("password") String password,RedirectAttributes redirectAttributes, ModelMap model)
	{
		
			boolean user = UserService.authenticateUser(username, password);
			if(user)
			{
				model.addAttribute("USER", user);
				return "home";
			}
			else
			{
				redirectAttributes.addAttribute("error", "Invalid username and password!");
				return "redirect:login";
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
