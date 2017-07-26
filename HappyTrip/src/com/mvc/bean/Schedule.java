package com.mvc.bean;

public class Schedule {
private int dep;
private int arr;
private String airline;
private String deptime;
private String arrtime;
private String flightno;
private long duration;
private int cost;
private int seats;
private String flightdate;

public String getFlightdate() {
	return flightdate;
}
public void setFlightdate(String flightdate) {
	this.flightdate = flightdate;
}
public int getDep() {
	return dep;
}
public void setDep(int dep) {
	this.dep = dep;
}
public int getArr() {
	return arr;
}
public void setArr(int arr) {
	this.arr = arr;
}
public String getAirline() {
	return airline;
}
public void setAirline(String airline) {
	this.airline = airline;
}
public String getDeptime() {
	return deptime;
}
public void setDeptime(String deptime) {
	this.deptime = deptime;
}
public String getArrtime() {
	return arrtime;
}
public void setArrtime(String arrtime) {
	this.arrtime = arrtime;
}
public String getFlightno() {
	return flightno;
}
public void setFlightno(String flightno) {
	this.flightno = flightno;
}
public long getDuration() {
	return duration;
}
public void setDuration(long duration) {
	this.duration = duration;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public int getSeats() {
	return seats;
}
public void setSeats(int seats) {
	this.seats = seats;
}
}
