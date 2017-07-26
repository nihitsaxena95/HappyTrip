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

import com.mvc.BookingMain;
import com.mvc.bean.AfterFlightData;
import com.mvc.bean.AirlineCity;
import com.mvc.bean.AirportCity;
import com.mvc.bean.Booking;
import com.mvc.bean.Seat;  

@Controller
public class BookingCntrl {
	
	@Autowired
	BookingMain bm;
	
	@RequestMapping(value="/stmain")
	public ModelAndView formmain(ModelMap mm) {
		List<AirportCity> ls = bm.getdrop1();
		List<AirlineCity> ls1 = bm.getdrop2();
		mm.addAttribute("airport",ls);
		mm.addAttribute("airline",ls1);
		return new ModelAndView("stmain","command", new Booking());
	}
	private String date;
	@RequestMapping(value="/getflightdata",method=RequestMethod.POST)
	public ModelAndView getflightdata(@ModelAttribute("book") Booking book,ModelMap mm ) {
		AfterFlightData ls = bm.getFlightData(book);
		date = book.getDate();
		if(ls.getTs().size() == 0) {
			mm.addAttribute("message","No flights Available");
			List<AirportCity> ls2 = bm.getdrop1();
			List<AirlineCity> ls1 = bm.getdrop2();
			mm.addAttribute("airport",ls2);
			mm.addAttribute("airline",ls1);
			return new ModelAndView("stmain","command", new Booking());
		}
		else {
		return new ModelAndView("flightdata","list",ls);
		}
		}
	
	@RequestMapping(value="/cnfmflightseat",method=RequestMethod.GET)
	public ModelAndView getflightdata(@ModelAttribute("seat") Seat seat,ModelMap mm) {
		System.out.println(seat.getSeat());
		boolean flag = bm.cnfmseat(seat);
		if(flag) {
		return new ModelAndView("redirect:/stmain.html");
	}
	else {
		System.out.println("here");
			mm.addAttribute("message","Seats not available");
			return new ModelAndView("seatbook","command",new Seat());
		}
	}
	
	@RequestMapping(value="/bookflightseat/{flightno}",method=RequestMethod.GET)
		public ModelAndView bookflight(@PathVariable String flightno,ModelMap mm) {
		bm.put(flightno,date);
		return new ModelAndView("seatbook","command",new Seat());
		}
	}
