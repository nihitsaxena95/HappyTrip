package com.mvc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.mvc.bean.Airline;

import java.sql.*;
import java.util.*;

public class AirInfoMain {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}

public Airline getAirline(String id){  
    String sql="select * from airlineinformation where airline_code=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Airline>(Airline.class));  
}  

public int update(Airline air) {
	String sql = "update airlineinformation set airline_name ='"+air.getAirline_name()+"' where airline_code ='"+air.getAirline_code()+"';";
	return template.update(sql);
}

public int delete(String id) {
	String sql="delete from airlineinformation where airline_code ='"+id+"';";
	return template.update(sql);
}

public boolean save(Airline air) {
	List<Airline> ls = template.query("select * from airlineinformation", new RowMapper<Airline>() {
		public Airline mapRow(ResultSet rs,int row) throws SQLException {
			Airline ar = new Airline();
			ar.setAirline_code(rs.getString(2));
			ar.setAirline_name(rs.getString(1));
			
			return ar;
		}
	});
	if(ls.size()== 0) {
	String sql = "insert into airlineinformation values('"+air.getAirline_name()+"','"+air.getAirline_code()+"')";
	template.update(sql);
	return true;
} else {
	return false;
}
}

public List<Airline> gett() {
	return template.query("select * from airlineinformation", new RowMapper<Airline>() {
		public Airline mapRow(ResultSet rs,int row) throws SQLException {
			Airline ar = new Airline();
			ar.setAirline_code(rs.getString(2));
			ar.setAirline_name(rs.getString(1));
			
			return ar;
		}
	});
}
}
