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

import com.mvc.ScheduleMain;
import com.mvc.bean.AirlineCity;
import com.mvc.bean.AirportCity;
import com.mvc.bean.Schedule;
import com.mvc.service.*;
@Controller
public class ScheduleCntrl {

	@Autowired
	ScheduleMain am;
	CalDurationSchedule cds = new CalDurationSchedule();
	
	@RequestMapping("/schedule")
	public ModelAndView go() {
		List<Schedule> list = am.gett();
		
		return new ModelAndView("scheduleinfo","list",list);
	}
	
	@RequestMapping(value="/scheduleupdate/{dep},{arr}",method=RequestMethod.GET)
	public ModelAndView upd(@PathVariable int dep,@PathVariable int arr,ModelMap mm) {
		Schedule amp = am.getSchedule(dep,arr);
		//System.out.println(amp.getSchedule_name());
		//List<AirportCity> ls = am.getdrop1();
		List<AirlineCity> ls1 = am.getdrop2();
		//mm.addAttribute("ls",ls);
		mm.addAttribute("ls1",ls1);
		return new ModelAndView("scheduleupdate","command",amp);
	}
	
	@RequestMapping(value="/scheduleupdatesave",method=RequestMethod.GET) 
	public ModelAndView updsave (@ModelAttribute("air")Schedule air, ModelMap mm) {
		
		boolean t = am.update(air);
		
		return new ModelAndView("redirect:/schedule.html");
		
		}
	
	@RequestMapping(value="/scheduledelete/{dep},{arr}",method=RequestMethod.GET)
	public ModelAndView del(@PathVariable int dep,@PathVariable int arr) {
		am.delete(dep,arr);
		return new ModelAndView("redirect:/schedule.html");
	}
	
	@RequestMapping(value="/addnewschedule")
	public ModelAndView newair(ModelMap mm) {
		
		List<AirportCity> ls = am.getdrop1();
		List<AirlineCity> ls1 = am.getdrop2();
		mm.addAttribute("ls",ls);
		mm.addAttribute("ls1",ls1);
		return new ModelAndView("addnewschedule","command",new Schedule());
	}
	
	@RequestMapping(value="/savenewschedule",method=RequestMethod.GET)
	public ModelAndView saveair(@ModelAttribute("air")Schedule air,ModelMap mm) {
		long duration = cds.dur(air.getDeptime(),air.getArrtime());
		air.setDuration(duration);
		boolean t =am.save(air);
		
			return new ModelAndView("redirect:/schedule.html");
			
	}
}
