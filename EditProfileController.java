package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.HibernateConnection;
import com.springmvc.model.ListUser;
@Controller
public class EditProfileController {
	

	@RequestMapping(value="/EditProfile",method=RequestMethod.GET)
	public String showuser(HttpServletRequest req , Model md , HttpSession session ,@Valid @ModelAttribute("user")ListUser user, BindingResult br){
		try {
			String username = (String) session.getAttribute("Username");
			EditprofileManager ed = new EditprofileManager();
				ListUser message = ed.doHibernateShowProfile(username);
				
				session.setAttribute("user",message);
	
			return "EditProfile";
		
			
		}catch(Exception e){
			md.addAttribute("login", user);
			return "EditProfile";
			}
	}
	
	
}
