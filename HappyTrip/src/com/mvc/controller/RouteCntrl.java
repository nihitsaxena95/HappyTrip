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

import com.mvc.RouteMain;
import com.mvc.bean.Route;
import com.mvc.bean.Schedule;
import com.mvc.service.*;
@Controller
public class RouteCntrl {
	
	public class AirInfoCntrloller {

		@Autowired
		RouteMain main;
		CalCost cc = new CalCost();
		
		@RequestMapping(value="/viewpage")
		public ModelAndView viewroute() {
			List<Route> ls = main.gett();
			return new ModelAndView("routeview","list",ls);
		}
		
		@RequestMapping(value="/routeupdate",method = RequestMethod.GET)
		public ModelAndView update(@ModelAttribute("r") Route r) {
			int cost = cc.costcal(r.getDistance());
			r.setCost(cost);
			main.getRoute(r);
			return new ModelAndView("air_route", "command", new Route());
		}
		
		@RequestMapping(value = "/deleteroute/{dep}", method = RequestMethod.GET)
		public ModelAndView delete(@PathVariable("dep") Route dep) {
			main.delete(dep);
			return new ModelAndView("redirect:/routeview.html");		//To be Completed
		}
		

	}
}
