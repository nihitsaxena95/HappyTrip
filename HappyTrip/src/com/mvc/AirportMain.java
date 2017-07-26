package com.mvc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.mvc.bean.Airport;

import java.sql.*;
import java.util.*;

public class AirportMain {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}

public Airport getAir(int id){  
    String sql="select * from airportinformation where Airport_code=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Airport>(Airport.class));  
}  

public int update(Airport air) {
	String sql = "update airportinformation set Airport_name ='"+air.getAirport_name()+"',city ='"+air.getCity()+"' where Airport_code ="+air.getAirport_code()+";";
	return template.update(sql);
}

public int delete(int id) {
	String sql="delete from airportinformation where Airport_code ="+id;
	return template.update(sql);
}

public boolean save(Airport air) {
	List<Airport> ls = template.query("select * from airportinformation where Airport_code="+air.getAirport_code()+";", new RowMapper<Airport>() {
		public Airport mapRow(ResultSet rs,int row) throws SQLException {
			Airport ar = new Airport();
			ar.setAirport_code(rs.getInt(1));
			ar.setAirport_name(rs.getString(2));
			ar.setCity(rs.getString(3));
			return ar;
		}
	});
	if(ls.size() == 0) {
	String sql = "insert into airportinformation values("+air.getAirport_code()+",'"+air.getAirport_name()+"','"+air.getCity()+"')";
	template.update(sql);
	return true;
	}
	else {
		return false;
	}
}

public List<Airport> gett() {
	return template.query("select * from airportinformation", new RowMapper<Airport>() {
		public Airport mapRow(ResultSet rs,int row) throws SQLException {
			Airport ar = new Airport();
			ar.setAirport_code(rs.getInt(1));
			ar.setAirport_name(rs.getString(2));
			ar.setCity(rs.getString(3));
			return ar;
		}
	});
}
}
