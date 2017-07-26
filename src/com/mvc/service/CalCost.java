package com.mvc.service;

public class CalCost {
	
	public int costcal(int distance)
	{
		int cost;
		
		if(distance>1000) {
			cost = distance*5;
		
	} else 
		cost = distance*7;	
		
		return cost;
	}
	
}