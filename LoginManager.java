package com.springmvc.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.springmvc.model.DatabaseConnection;
import com.springmvc.model.HibernateConnection;
import com.springmvc.model.ListUser;
import com.springmvc.model.LoginBean;


public class LoginManager {
	/*public String doHibernateLogin(LoginBean login){
		try{
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<LoginBean> user = session.createQuery("From LoginBean where username='" +login.getUsername()+ 
													"' and Password='"+login.getPassword()+ "'").list();
			session.close();
			if(user.size() == 1) {
				return "login success" ;
			} else {
				return "username or password does't match";
			}
			}catch(Exception ex){
			return "Login error, please try again!!";
		}
	}*/
	
	public String do_login_process(LoginBean login) {     
		DatabaseConnection dbcon = new DatabaseConnection();     
		Connection conn = dbcon.getConnection();     
		Statement stmt = null;     
		ResultSet rs = null;     
		try{   
			String sql = "select count(username) from " + "Login where username = '" + login.getUsername() + "' and password = '" + login.getPassword() + "'";   
			stmt = conn.createStatement();   
			rs = stmt.executeQuery(sql);    
			int count = 0;   
			if (rs.next()){      
				count = rs.getInt(1);   
			}   
			if (count == 1) {      
				return "login success";   
			}else {      
				return "username or password does't match";   
			}     
		}catch(Exception ex){  
			return "Login error, please try again!!";     
		}finally{   
			try {      
				rs.close();      
				stmt.close();      
				conn.close();   
			} catch (SQLException e) {      
				e.printStackTrace();   
			}      
		}  
	}
}
