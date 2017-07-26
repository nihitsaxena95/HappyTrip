package com.mvc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.mvc.bean.Airline;
import com.mvc.bean.Flight;

import java.sql.*;
import java.util.*;

public class FlightMain {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}

public Flight getFlight(String id){  
    String sql="select * from flight where Flightno=?";
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Flight>(Flight.class));  
}  

public int update(Flight air) {
	String sql = "update flight set name ='"+air.getName()+"',airline ='"+air.getAirline()+"',capacity="+air.getCapacity()+" where Flightno ='"+air.getFlightno()+"';";
	return template.update(sql);
}

public int delete(String id) {
	String sql="delete from flight where Flightno ='"+id+"'";
	return template.update(sql);
}

public boolean save(Flight air) {
	List<Flight> ls = template.query("select * from flight where Flightno='"+air.getFlightno()+"';", new RowMapper<Flight>() {
		public Flight mapRow(ResultSet rs,int row) throws SQLException {
			Flight ar = new Flight();
			ar.setName(rs.getString(1));
			ar.setFlightno(rs.getString(2));
			ar.setAirline(rs.getString(3));
			ar.setCapacity(rs.getInt(4));
			return ar;
		}
	});
	List<Airline> ls1 = template.query("select * from airlineinformation where Airline_code='"+air.getAirline()+"';", new RowMapper<Airline>() {
		public Airline mapRow(ResultSet rs,int row) throws SQLException {
			Airline ar = new Airline();
			ar.setAirline_code(rs.getString(2));
			return ar;
		}
	});
	if(ls.size()==0 && ls1.size()!=0) {
	String sql = "insert into flight values('"+air.getName()+"','"+air.getFlightno()+"','"+air.getAirline()+"',"+air.getCapacity()+")";
	template.update(sql);
	return true;
	}
	else {
		return false;
	}
}

public List<Flight> gett() {
	return template.query("select * from flight", new RowMapper<Flight>() {
		public Flight mapRow(ResultSet rs,int row) throws SQLException {
			Flight ar = new Flight();
			ar.setName(rs.getString(1));
			ar.setFlightno(rs.getString(2));
			ar.setAirline(rs.getString(3));
			ar.setCapacity(rs.getInt(4));
			return ar;
		}
	});
}
}
