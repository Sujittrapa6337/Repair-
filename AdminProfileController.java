package com.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AdminProfileController {
	@RequestMapping(value="/AdminProfile",method=RequestMethod.GET)
	public ModelAndView loadProfilePage(HttpSession session){
		ModelAndView mav = new ModelAndView("AdminProfile");
		String uname =(String)session.getAttribute("emp_username");
		mav.addObject("emp_username", uname);
		return mav;
		}
}
