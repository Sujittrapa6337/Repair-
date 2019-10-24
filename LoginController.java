package com.springmvc.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.ListUser;
import com.springmvc.model.LoginBean;

import Utilities.PasswordEncrypt;

@Controller
public class LoginController {
	/*@RequestMapping(value="/login", method=RequestMethod.GET)
		public ModelAndView loadLoginPage(){
			ModelAndView mav = new ModelAndView("login");
			LoginBean login = new LoginBean();
			mav.addObject("login", login);
			return mav;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String do_login(HttpServletRequest req , Model md , HttpSession session ,@Valid @ModelAttribute("user")LoginBean user, BindingResult br){
		try {
			String uname = req.getParameter("username");
			String pwd = req.getParameter("password");
			if(br.getAllErrors().size()>0){
			md.addAttribute("error_msg",br.getAllErrors().get(0).getDefaultMessage());
			return "login";
			}else{
				LoginManager lm = new LoginManager();
				String message = lm.doHibernateLogin(user);
			if(message.equals("login success")) {
				session.setAttribute("Username",user.getUserID());
			return "myprofile";
			}else {
			md.addAttribute("error_msg", message);
			}
			}
			return "login";
		}catch(Exception e){
			md.addAttribute("login", user);
			return "login";
			}
		}*/
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loadLoginPage(){
		ModelAndView mav = new ModelAndView("login");
		LoginBean user = new LoginBean();
		mav.addObject("user", user);
		return mav;
}
@RequestMapping(value="/login", method=RequestMethod.POST)
public String do_login(HttpServletRequest req , Model md , HttpSession session ,@Valid @ModelAttribute("user")LoginBean user, BindingResult br){
	try {
		String uname = req.getParameter("username");
		String pwd = req.getParameter("password");
		LoginBean login = new LoginBean(uname,pwd);          
		LoginManager lmg = new LoginManager();          
		String message = lmg.do_login_process(login);             
		if (message.equals("login success")) {    
			session.setAttribute("emp_username",login.getUsername());   
			return "myprofile";          
		}else{   
			md.addAttribute("error_msg", message);          
		}          
		return "login";
	}catch(Exception e){
		md.addAttribute("login", user);
		return "login";
		}
	}
}
