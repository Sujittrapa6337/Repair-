package com.springmvc.controller;

import java.util.List;

import org.hibernate.Session;

import com.springmvc.model.Building;
import com.springmvc.model.HibernateConnection;
import com.springmvc.model.ListUser;
import com.springmvc.model.Repairlist;
import com.springmvc.model.Room;


public class insertManager {
	public String doHibernateInsertRepair(Repairlist insertRepairlist) {
		try {
			Session session = HibernateConnection.doHibernateConnection().openSession();
			
			session.beginTransaction();
			session.save(insertRepairlist);
			session.getTransaction().commit();
			session.close();
			return "แจ้งซ่อมสำเร็จ";
		} catch (Exception e) {
			e.printStackTrace();
			return "มีข้อมูลผิดพลาด";
		}
	}
	
	public ListUser userlist(String u) {
		try {
			Session session = HibernateConnection.doHibernateConnection().openSession();
			session.beginTransaction();
			List<ListUser> list = session.createQuery("From ListUser where UserID='" +u+ "'").list();
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Building buildinglist(String buildingNo) {
		try {
			Session session = HibernateConnection.doHibernateConnection().openSession();
			session.beginTransaction();
			List<Building> list = session.createQuery("From Building where BuildingID='" +buildingNo+ "'").list();
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Room roomlist(String roomID) {
		try {
			Session session = HibernateConnection.doHibernateConnection().openSession();
			session.beginTransaction();
			List<Room> list = session.createQuery("From Room where RoomID='" +roomID+ "'").list();
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
