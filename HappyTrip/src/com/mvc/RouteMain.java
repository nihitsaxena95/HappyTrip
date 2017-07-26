package com.mvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mvc.bean.Route;

public class RouteMain {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int getRoute(Route r){  
	    String sql="Insert Into kms values("+r.getDep()+","+r.getArr()+","+r.getDistance()+","+r.getTime()+","+r.getCost()+")";  
	    return template.update(sql);
	}  

	public int delete(Route id) {
		String sql="delete * from kms where Dep ="+id.getDep()+", arr="+id.getArr()+";";
		return template.update(sql);
	}

	public List<Route> gett() {
		return template.query("select * from Routeinformation", new RowMapper<Route>() {
			public Route mapRow(ResultSet rs,int row) throws SQLException {
				Route ar = new Route();
				ar.setDep(rs.getInt(1));
				ar.setArr(rs.getInt(2));
				ar.setDistance(rs.getInt(3));
				ar.setTime(rs.getInt(4));
				ar.setCost(rs.getInt(5));
				
				return ar;
			}
		});
	}
	
}
