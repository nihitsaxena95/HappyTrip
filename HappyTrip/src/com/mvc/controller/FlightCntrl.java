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

import com.mvc.FlightMain;
import com.mvc.bean.Flight;  

@Controller
public class FlightCntrl {

	@Autowired
	FlightMain am;
	
	@RequestMapping("/flight")
	public ModelAndView go() {
		List<Flight> list = am.gett();
		return new ModelAndView("flightinfo","list",list);
	}
	
	@RequestMapping(value="/flightupdate/{id}",method=RequestMethod.GET)
	public ModelAndView upd(@PathVariable("id") String id) {
		System.out.println(id);
		Flight amp = am.getFlight(id);
	//	System.out.println(amp.getflight_name());
		return new ModelAndView("flightupdate","command",amp);
	}
	
	@RequestMapping(value="/flightupdatesave",method=RequestMethod.GET) 
	public ModelAndView updsave (@ModelAttribute("air")Flight air) {
		//System.out.println(air.getflight_code());
		am.update(air);
		return new ModelAndView("redirect:/flight.html");
	}
	
	@RequestMapping(value="/flightdelete/{id}",method=RequestMethod.GET)
	public ModelAndView del(@PathVariable String id) {
		am.delete(id);
		return new ModelAndView("redirect:/flight.html");
	}
	
	@RequestMapping(value="/addnewflight")
	public ModelAndView newair() {
		
		return new ModelAndView("addnewflight","command",new Flight());
	}
	
	@RequestMapping(value="/savenewflight",method=RequestMethod.GET)
	public ModelAndView saveair(@ModelAttribute("air")Flight air,ModelMap mm) {
	boolean flag=am.save(air);
	if(flag) {
		return new ModelAndView("redirect:/flight.html");
	} else {
		mm.addAttribute("mess","flightno or Airline not Available");
		return new ModelAndView("addnewflight","command",new Flight());
	}
	}
}
