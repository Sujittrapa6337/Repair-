package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.springmvc.model.HibernateConnection;
import com.springmvc.model.Repairlist;


public class RepairListManager {
	public List<Repairlist> getListRepair() {
		List<Repairlist> Repairlist = new ArrayList<Repairlist>();
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Repairlist = session.createQuery("From Repairlist").list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Repairlist;
	}
	
	public List<Repairlist> getListbuilding() {
		List<Repairlist> listBuilding = new ArrayList<Repairlist>();
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			listBuilding = session.createQuery("From Repairlist").list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBuilding;
	}
}
