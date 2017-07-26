package com.mvc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.mvc.bean.Route;
import com.mvc.bean.User;

import java.sql.*;
import java.util.*;

public class Usermain {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}

public boolean save(User u) {
	String chk = "select * from user where username='"+u.getUsername()+"';";
	List<User> u1 = template.query(chk, new RowMapper<User>() {
		public User mapRow(ResultSet rs,int row) throws SQLException {
			User ar = new User();
			ar.setUsername(rs.getString(2));
			return ar;
		}
	});
	if(u1.size()!=0) {
		return false;
	}
	else {
	String sql = "insert into user values('"+u.getName()+"','"+u.getUsername()+"','"+u.getPassword()+"','"+u.getEmail()+"','user');";
	System.out.println(u.getUsername());
	template.update(sql);
	return true;
}
}


public String check(String user,String pass) {
	System.out.println(user);
	String sql = "select * from user where username=?;";
	User u1 = template.queryForObject(sql, new Object[]{user},new BeanPropertyRowMapper<User>(User.class));
	System.out.println("password : "+u1.getPassword());
	
	if(pass.equals(u1.getPassword())) {
		System.out.println(u1.getType());
		return u1.getType();
	}
	else {
		return "";	
	}
	
}
}
