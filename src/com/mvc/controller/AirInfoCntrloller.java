package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.AirInfoMain;
import com.mvc.bean.Airline;
import com.mvc.*;

@Controller
public class AirInfoCntrloller {

	@Autowired
	AirInfoMain main;

	@RequestMapping("/addairline")
	public ModelAndView showform() {
		return new ModelAndView("addnewairline", "command", new Airline());
	}

	@RequestMapping(value = "/addairlineinfo", method = RequestMethod.GET)
	public ModelAndView add(@ModelAttribute("air") Airline air,ModelMap mm) {
		boolean flag = main.save(air);
		if(flag) {
			return new ModelAndView("redirect:/viewair.html");	
		}
		else {
			mm.addAttribute("mess","Airline Code Not Available");
			return new ModelAndView("addnewairline", "command", new Airline());
		}
	}

	@RequestMapping(value = "/updateairline/{airline_code}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("airline_code") String airline_code) {
		Airline airline = main.getAirline(airline_code);
		return new ModelAndView("airlineupdate", "command", airline);
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView editsave(@ModelAttribute("air") Airline air) {
		main.update(air);
		return new ModelAndView("redirect:/viewair.html");
	}

	@RequestMapping(value = "/deleteairline/{airline_code}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("airline_code") String airline_code) {
		main.delete(airline_code);
		return new ModelAndView("redirect:/viewair.html");
	}

	@RequestMapping("/viewair")
	public ModelAndView viewAir() {
		List<Airline> list = main.gett();
		System.out.println("in view");
		return new ModelAndView("airlineinfo", "list", list);

	}
}
