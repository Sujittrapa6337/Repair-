package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.springmvc.model.HibernateConnection;
import com.springmvc.model.Repairlist;


public class Repair2ListManager {
	public List<Repairlist> getListRepair() {
		List<Repairlist> Repairlist2 = new ArrayList<Repairlist>();
		try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Repairlist2 = session.createQuery("From Repairlist").list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Repairlist2;
	}
}
