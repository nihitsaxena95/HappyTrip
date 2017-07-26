package com.mvc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.mvc.bean.AirlineCity;
import com.mvc.bean.AirportCity;
import com.mvc.bean.Schedule;

import java.sql.*;
import java.util.*;

public class ScheduleMain {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
Schedule se;
public Schedule getSchedule(int dep,int arr){  
    String sql="select * from schedule where dep="+dep+" and arr="+arr+";";  
   List<Schedule> ls = template.query(sql, new RowMapper<Schedule>() {
		public Schedule mapRow(ResultSet rs,int row) throws SQLException {
			Schedule ar = new Schedule();
			ar.setDep(rs.getInt(1));
			ar.setArr(rs.getInt(2));
			ar.setDeptime(rs.getString(8));
			ar.setFlightno(rs.getString(9));
			ar.setAirline(rs.getString(3));
			ar.setArrtime(rs.getString(4));
			ar.setCost(rs.getInt(5));
			ar.setDuration(rs.getInt(7));
			ar.setSeats(rs.getInt(6));
			ar.setFlightdate(rs.getString(10));
			return ar;
		}
	});
  
   for(Schedule s:ls) {
	   se =s;
   }
   return se;
}  

public boolean update(Schedule sch) {
	//String sql1 = "select * from airlineinformation where airline_code=?";
	//Airline ar = template.queryForObject(sql1, new Object[]{sch.getAirline()},new BeanPropertyRowMapper<Airline>(Airline.class));
//	System.out.println(ar.getAirline_code());
//	String sql2 = "select * from flight where Flightno=?";
//	Flight fl = template.queryForObject(sql2, new Object[]{sch.getFlightno()},new BeanPropertyRowMapper<Flight>(Flight.class));
	//System.out.println(ar.getAirline_code()+" "+fl.getFlightno());
	if(true) {
		String sql = "update schedule set airline='"+sch.getAirline()+"',arrtime='"+sch.getArrtime()+"',cost="+sch.getCost()+",deptime='"+sch.getDeptime()+"',duration="+sch.getDuration()+",flightno='"+sch.getFlightno()+"',seats="+sch.getSeats()+",flightdate='"+sch.getFlightdate()+"' where dep="+sch.getDep()+" and arr ="+sch.getArr()+";";
		template.update(sql);
		return true;
	}
	else {
		return false;
	}
	
}

public List<AirportCity> getdrop1() {
	String sql1 = "select * from airportinformation;";
	List<AirportCity> ls1 = template.query(sql1, new RowMapper<AirportCity>() {
		public AirportCity mapRow(ResultSet rs,int row) throws SQLException {
			AirportCity ar = new AirportCity();
			ar.setCode(rs.getInt(1));
			ar.setCity(rs.getString(3));
			return ar;
		}
	});
	return ls1;
}

public List<AirlineCity> getdrop2() {
	String sql3 = "select * from airlineinformation;";
	List<AirlineCity> ls2 = template.query(sql3, new RowMapper<AirlineCity>() {
		public AirlineCity mapRow(ResultSet rs,int row) throws SQLException {
			AirlineCity ar = new AirlineCity();
			ar.setAirline_code(rs.getString(2));
			ar.setAirline_name(rs.getString(1));
			return ar;
		}
	});
	return ls2;
}

public int delete(int dep,int arr) {
	String sql="delete from schedule where dep ="+dep+" and arr ="+arr;
	return template.update(sql);
}

public boolean save(Schedule sch) {
	
		String sql = "insert into schedule values("+sch.getDep()+","+sch.getArr()+",'"+sch.getAirline()+"','"+sch.getArrtime()+"',"+sch.getCost()+","+sch.getSeats()+","+sch.getDuration()+",'"+sch.getDeptime()+"','"+sch.getFlightno()+"','"+sch.getFlightdate()+"');";
		template.update(sql);
		return true;
	
	}

public List<Schedule> gett() {
	return template.query("select * from schedule", new RowMapper<Schedule>() {
		public Schedule mapRow(ResultSet rs,int row) throws SQLException {
			Schedule ar = new Schedule();
			ar.setDep(rs.getInt(1));
			ar.setArr(rs.getInt(2));
			ar.setDeptime(rs.getString(8));
			ar.setFlightno(rs.getString(9));
			ar.setAirline(rs.getString(3));
			ar.setArrtime(rs.getString(4));
			ar.setCost(rs.getInt(5));
			ar.setDuration(rs.getInt(7));
			ar.setSeats(rs.getInt(6));
			ar.setFlightdate(rs.getString(10));
			return ar;
		}
	});
}
}
