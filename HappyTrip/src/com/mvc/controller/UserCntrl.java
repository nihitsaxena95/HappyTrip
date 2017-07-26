package com.mvc.controller;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;

import com.mvc.Usermain;
import com.mvc.bean.User;  

@Controller
public class UserCntrl {

	@Autowired
	Usermain um;
	
	@RequestMapping("/userform") 
	public ModelAndView put() {
		return new ModelAndView("userreg","command",new User());
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST) 
	public ModelAndView save(@ModelAttribute("usr")User usr,ModelMap mm) {
		boolean tr =um.save(usr);
		if(tr) {
		return new ModelAndView("redirect:/login.html");
	} else {
		mm.addAttribute("message", "Username not Available");
		return new ModelAndView("userreg","command",new User());
	}
	}
	
	@RequestMapping("/login")
	public ModelAndView log() {
		return new ModelAndView("loginview","command",new User());
	}
	
	@RequestMapping(value="/check",method=RequestMethod.POST)
	public ModelAndView check(@ModelAttribute("usr")User usr,ModelMap mm) {
		String t = um.check(usr.getUsername(),usr.getPassword());
		System.out.println("t value = "+t);
		if(t.equals("admin")) {
			return new ModelAndView("redirect:/main.html");
		} else if(t.equals("user")) {
			return new ModelAndView("redirect:/stmain.html");
		}
		else {
			mm.addAttribute("message", "Invalid Credentials");
			return new ModelAndView("loginview","command",new User());
		}
	}
	
	@RequestMapping("/main")
	public ModelAndView mainn() {
		return new ModelAndView ("main","mess","welcome");
	}
	
}
