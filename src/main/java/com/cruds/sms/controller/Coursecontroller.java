package com.cruds.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cruds.sms.entity.Course;
import com.cruds.sms.entity.Student;
import com.cruds.sms.service.CourseService;
import com.cruds.sms.service.StudentService;

@Controller
public class Coursecontroller {

	
	@RequestMapping(value="/course", method=RequestMethod.GET)
	public ModelAndView showStudentForm()
	{
		System.out.println("Inside Show course Form GET");
		ModelAndView mv = new ModelAndView("course", "command", new Course());
		mv.addObject("COURSELIST", CourseService.getAllCourse());
		
		return mv;
	}
	
/*	@RequestMapping(value="/student", method=RequestMethod.POST)
	public String processStudentForm(@RequestParam("rollNo") int rollNo, @RequestParam("firstName") String firstName,
													@RequestParam("lastName") String lastName)
	{
		System.out.println(rollNo + ":" + firstName + ":" + lastName );  
		return "student";
	}*/	
	
	@RequestMapping(value="/course", method=RequestMethod.POST)
	public String processCourseForm(@ModelAttribute("course") Course course)
	{
		
		CourseService.create(course);
		return "redirect:course.html";
	}
	
	@RequestMapping(value="/delete-{courseid}", method=RequestMethod.GET)
	public String deleteCourseForm(@PathVariable int courseid)
	{
		
		CourseService.delete(courseid);
		return "redirect:course.html";
	}
	
	
	
}
