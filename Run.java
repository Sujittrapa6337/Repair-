package com.springmvc.model;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.springmvc.controller.LoginManager;

public class Run {

	public static void main(String[] args) {
		try{
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.getTransaction().commit();
			session.close();
			System.out.println("Sucessful");
			}catch(Exception ex){
				System.out.println("Duplicate"); 
		}
	}

}
