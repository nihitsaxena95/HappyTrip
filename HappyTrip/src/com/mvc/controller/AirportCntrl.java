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

import com.mvc.AirportMain;
import com.mvc.bean.Airport;  

@Controller
public class AirportCntrl {

	@Autowired
	AirportMain am;
	
	@RequestMapping("/airport")
	public ModelAndView go() {
		List<Airport> list = am.gett();
		return new ModelAndView("airportinfo","list",list);
	}
	
	@RequestMapping(value="/airportupdate/{id}",method=RequestMethod.GET)
	public ModelAndView upd(@PathVariable("id") int id) {
		System.out.println(id);
		Airport amp = am.getAir(id);
		System.out.println(amp.getAirport_name());
		return new ModelAndView("airportupdate","command",amp);
	}
	
	@RequestMapping(value="/airportupdatesave",method=RequestMethod.GET) 
	public ModelAndView updsave (@ModelAttribute("air")Airport air) {
		System.out.println(air.getAirport_code());
		am.update(air);
		return new ModelAndView("redirect:/airport.html");
	}
	
	@RequestMapping(value="/airportdelete/{id}",method=RequestMethod.GET)
	public ModelAndView del(@PathVariable int id) {
		am.delete(id);
		return new ModelAndView("redirect:/airport.html");
	}
	
	@RequestMapping(value="/addnewairport")
	public ModelAndView newair() {
		return new ModelAndView("addnewairport","command",new Airport());
	}
	
	@RequestMapping(value="/savenewairport",method=RequestMethod.GET)
	public ModelAndView saveair(@ModelAttribute("air")Airport air,ModelMap mm) {
		boolean flag = am.save(air);
		if(flag) {
		return new ModelAndView("redirect:/airport.html");
	} else {
		mm.addAttribute("mess","Airport Code not Available");
		return new ModelAndView("addnewairport","command",new Airport());
	}
	}
}
