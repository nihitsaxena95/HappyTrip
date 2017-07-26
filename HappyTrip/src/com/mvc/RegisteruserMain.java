package com.mvc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.mvc.bean.User;

import java.sql.*;
import java.util.*;

public class RegisteruserMain {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}

public int save(User u) {
	String sql = "insert into user('"+u.getName()+"','"+u.getUsername()+"','"+u.getPassword()+"','"+u.getEmail()+"');";
	return (template.update(sql));
}



public int delete(String username){  
    String sql="delete from user where username='"+username+"'";
    return template.update(sql);
}  

public List<User> getUsers(){  
    return template.query("select * from user",new RowMapper<User>(){  
        public User mapRow(ResultSet rs, int row) throws SQLException {  
            User u=new User();  
            u.setName(rs.getString(1));  
            u.setUsername(rs.getString(2));  
            u.setPassword(rs.getString(3));  
            u.setEmail(rs.getString(4));  
            return u;  
        }  
    });  
}  
}
