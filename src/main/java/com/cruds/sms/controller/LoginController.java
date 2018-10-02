package com.cruds.sms.controller;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cruds.sms.entity.Student;
import com.cruds.sms.entity.User;
import com.cruds.sms.service.StudentService;
import com.cruds.sms.service.UserService;
@Controller
@SessionAttributes("USER")
public class LoginController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String redirecttoLogin()
	{
		return "login";
	}
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public ModelAndView showStudentForm()
	{
		System.out.println("Inside Show Student FOrm GET");
		ModelAndView mv = new ModelAndView("student", "command", new Student());
		mv.addObject("STUDENTLIST", StudentService.getAllStudents());
		
		return mv;
	}
	
	@RequestMapping(value="/checklogin",method=RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username,@RequestParam("password") String password,RedirectAttributes redirectAttributes, ModelMap model,HttpSession session)
	{
			if(username == null || password == null || username.trim().length() == 0 || password.trim().length() == 0)
			{
				redirectAttributes.addAttribute("error", "Invalid username and password!");
				return "redirect:login";
			}
			
			else
			{
			String user = UserService.authenticateUser(username, password);
			
			if(user == null)
			{
				redirectAttributes.addAttribute("error", "Invalid username and password!");
				return "redirect:login";
			}
			
			else if(user.equals("student"))
			{
				session.setAttribute("uname",username);
				model.addAttribute("USER", user);
				return "redirect:student.html";
			}
			
			else if (user.equals("Librarian"))
			{
				
					session.setAttribute("uname",username);
					model.addAttribute("USER", user);
					return "home";
				
			}
			else
			{
				redirectAttributes.addAttribute("error", "Please contact system admin!");
				return "redirect:login";
			}
			
			
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
	
	@RequestMapping(value = { "/logout"}, method = RequestMethod.GET)
    public String logout(HttpSession session,Model model,RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("logout","You have been logged out successfully.");
		session.invalidate();
		model.asMap().clear();
        return "redirect:login";
    }	
	
	@RequestMapping(value = { "/cancel"}, method = RequestMethod.GET)
    public String cancel(HttpSession session,Model model) {
		
		session.invalidate();
		model.asMap().clear();
        return "redirect:login";
    }	
	
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String redirecttohome()
	{
		return "home";
	}
	
	
}
