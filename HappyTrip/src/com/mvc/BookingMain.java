package com.mvc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.mvc.bean.AfterFlightData;
import com.mvc.bean.AirlineCity;
import com.mvc.bean.AirportCity;
import com.mvc.bean.Booking;
import com.mvc.bean.PreFlightData;
import com.mvc.bean.Seat;

import java.sql.*;
import java.util.*;

public class BookingMain {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}

public AfterFlightData getFlightData(Booking bk) {
	
	AfterFlightData afd = new AfterFlightData();
	String sql = "select * from airportinformation where Airport_code="+bk.getFromCity()+"";
	List<AirportCity> ls = template.query(sql, new RowMapper<AirportCity>() {
		public AirportCity mapRow(ResultSet rs,int row) throws SQLException {
			AirportCity ar = new AirportCity();
			ar.setCode(rs.getInt(1));
			ar.setCity(rs.getString(3));
			return ar;
		}
	});
	
	for(AirportCity ac:ls) {
		afd.setFromCity(ac); 
	}
	
	
	String sql1 = "select * from airportinformation where Airport_code="+bk.getToCity()+"";
	List<AirportCity> ls1 = template.query(sql1, new RowMapper<AirportCity>() {
		public AirportCity mapRow(ResultSet rs,int row) throws SQLException {
			AirportCity ar = new AirportCity();
			ar.setCode(rs.getInt(1));
			ar.setCity(rs.getString(3));
			return ar;
		}
	});
	
	for(AirportCity ac1:ls1) {
		afd.setToCity(ac1); 
	}
	System.out.println(bk.getFromCity()+" "+bk.getToCity()+" "+bk.getDate());
	
	
	String sql2 = "select * from schedule where dep = "+bk.getFromCity()+" and arr = "+bk.getToCity()+" and Flightdate = '"+bk.getDate()+"';";
	List<PreFlightData> ls9 = template.query("select * from schedule where dep="+bk.getFromCity()+" and arr="+bk.getToCity()+" and Flightdate='"+bk.getDate()+"';", new RowMapper<PreFlightData>() {
		public PreFlightData mapRow(ResultSet rs,int row) throws SQLException {
			PreFlightData ar = new PreFlightData();
			System.out.println("Here : "+rs.getString(8));
			ar.setDate(rs.getString(10));
			ar.setDeptime(rs.getString(8));
			ar.setArrtime(rs.getString(4));
			ar.setCost(rs.getInt(5));
			ar.setDuration(rs.getInt(7));
			ar.setFlightno(rs.getString(9));
			ar.setSeat(rs.getInt(6));
			if(rs.getInt(6)>0) {
			ar.setStatus("Available");
			} else {
				ar.setStatus("Not Available");
			}
			
			String sql3 = "select * from airlineinformation where Airline_code='"+rs.getString(3)+"';";
			List<AirlineCity> ls2 = template.query(sql3, new RowMapper<AirlineCity>() {
				public AirlineCity mapRow(ResultSet rs,int row) throws SQLException {
					AirlineCity ar = new AirlineCity();
					ar.setAirline_code(rs.getString(2));
					ar.setAirline_name(rs.getString(1));
					return ar;
				}
			});
			
			for(AirlineCity ac3:ls2) {
				afd.setAirline(ac3); 
			}
			return ar;
		}
	});
	
	
	afd.setTs(ls9);
	
	return afd;
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
String flightno;
String date;
public void put(String x,String y) {
	flightno =x;
	date=y;
}

Seat s2 = new Seat();
public boolean cnfmseat(Seat s) {
	System.out.println(flightno+" "+date);
	String sql3 = "select * from schedule where Flightno='"+flightno+"' and Flightdate ='"+date+"';";
	List<Seat> ls2 = template.query(sql3, new RowMapper<Seat>() {
		public Seat mapRow(ResultSet rs,int row) throws SQLException {
			Seat ar = new Seat();
			ar.setSeat(rs.getInt(6));
			return ar;
		}
	});
	
	for(Seat s1:ls2) {
	s2.setSeat(s1.getSeat());
	System.out.println("inside"+s2.getSeat());
	}
	if(s2.getSeat() > s.getSeat()) {
		s2.setSeat(s2.getSeat() - s.getSeat());
		String s3 = "update schedule set Seats="+s2.getSeat()+" where Flightno='"+flightno+"' and flightdate='"+date+"';";
		template.update(s3);
		return true;
	}
	else {
		return false;
	}
}
}
