package com.mvc.service;
import java.time.*;  
public class CalDurationSchedule {
			
		public long dur(String dep,String arr)
		{
			int deph = Integer.parseInt(dep.substring(0,2));
			int depm = Integer.parseInt(dep.substring(3,5));
			int arrh = Integer.parseInt(arr.substring(0,2));
			int arrm = Integer.parseInt(arr.substring(3,5));
			System.out.println(deph+" "+depm);
			Duration d1 = Duration.between(LocalTime.of(deph,depm ),LocalTime.of(arrh,arrm ));  
			System.out.println(d1.toMinutes());
		    return (d1.toMinutes()); 
		}

	}
