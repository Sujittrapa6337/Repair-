package com.springmvc.model;


import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
	public static SessionFactory sessionFactory;
	public static SessionFactory doHibernateConnection(){
	Properties database = new Properties();
	//database.setProperty("hibernate.hbm2ddl.auto","create");
	database.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
	database.setProperty("hibernate.connection.username","root");
	database.setProperty("hibernate.connection.password", "1234");
	database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ProjectWeb1");
	database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	Configuration cfg = new Configuration()
							.setProperties(database).addPackage("com.springmvc.model")
							.addAnnotatedClass(Building.class)
							.addAnnotatedClass(Major.class)
							.addAnnotatedClass(Room.class)
							.addAnnotatedClass(ListUser.class)
							.addAnnotatedClass(Repairlist.class);
	StandardServiceRegistryBuilder ssrb =new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
	sessionFactory = cfg.buildSessionFactory(ssrb.build());
	return sessionFactory;
	}
}
//.addAnnotatedClass(LoginAdmin.class).addAnnotatedClass(ListRepair.class)