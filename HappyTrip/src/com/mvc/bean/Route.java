package com.mvc.bean;

public class Route {
private int dep;
private int arr;
private int distance;
private int time;
private int cost;


public int getDep() {
	return dep;
}
public void setDep(int dep) {
	this.dep = dep;
}
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}
public int getArr() {
	return arr;
}
public void setArr(int arr) {
	this.arr = arr;
}
public int getDistance() {
	return distance;
}
public void setDistance(int kms) {
	this.distance = kms;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}

}
