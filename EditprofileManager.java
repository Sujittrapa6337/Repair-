package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.springmvc.model.HibernateConnection;
import com.springmvc.model.ListUser;
import com.springmvc.model.Repairlist;

public class EditprofileManager {
	public ListUser doHibernateShowProfile(String editProfile){
		try{
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<ListUser> profiledata = session.createQuery("From ListUser where UserID='" +editProfile+"'").list();
			session.close();
			return profiledata.get(0);
			}catch(Exception ex){
			return null;
		}
	}
	public String doHibernateEditUser(ListUser user){
		try{
		Session session =HibernateConnection.doHibernateConnection().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return "Edit Profile Successfully...";
		}catch(Exception e){
		e.printStackTrace();
		return "User is already there with this username";
		}
		} 
}
