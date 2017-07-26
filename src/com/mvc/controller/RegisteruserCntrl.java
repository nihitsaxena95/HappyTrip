package com.mvc.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;

import com.mvc.RegisteruserMain;
import com.mvc.bean.User;  

@Controller
public class RegisteruserCntrl {

	@Autowired
	RegisteruserMain um;

	@RequestMapping("/registeruser")  
    public ModelAndView viewUser(){  
		
        List<User> list=um.getUsers();  		
        return (new ModelAndView("registeruser","list",list));  
    }  
	
	@RequestMapping(value="/deleteuser/{username}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable String username){ 
        um.delete(username);
        return (new ModelAndView("redirect:/registeruser.html"));  
    }  
}
