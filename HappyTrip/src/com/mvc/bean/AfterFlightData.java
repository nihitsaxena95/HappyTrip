package com.mvc.bean;
import java.util.*;

public class AfterFlightData {
private AirportCity fromCity;
private AirportCity ToCity;
private AirlineCity airline;
private List<PreFlightData> ts;
public AirlineCity getAirline() {
	return airline;
}
public void setAirline(AirlineCity airline) {
	this.airline = airline;
}


public List<PreFlightData> getTs() {
	return ts;
}
public void setTs(List<PreFlightData> ts) {
	this.ts = ts;
}
public AirportCity getFromCity() {
	return fromCity;
}
public void setFromCity(AirportCity fromCity) {
	this.fromCity = fromCity;
}
public AirportCity getToCity() {
	return ToCity;
}
public void setToCity(AirportCity toCity) {
	ToCity = toCity;
}
}
