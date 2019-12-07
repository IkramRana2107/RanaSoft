package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.SEmployee;

public class Client {

	public static void main(String[] args) {
Configuration cfg=new Configuration();
cfg.configure();
SessionFactory sf =cfg.buildSessionFactory();
Session s=sf.openSession();
Transaction t=s.beginTransaction();
// SEmployee se=new SEmployee(111,"abc","ikram@gmail.com",50000,"hibernate");


	}

}
