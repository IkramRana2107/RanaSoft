package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import beans.Employee;

public class Client {
	public static void main(String args[])
	{
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml").build();
		Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=metadata.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Employee e1=new Employee(111,"abc","abc@gmail.com",60000);
		Employee e2=new Employee(222,"lmn","lmn@gmail.com",70000);
		Employee e3=new Employee(444,"def","def@gmail.com",80000);
		Employee e4=new Employee(555,"xyz","xyz@gmail.com",90000);
		s.save(e1);
		s.save(e2);
		s.save(e3);
		s.save(e4);
		t.commit();
		s.close();
		sf.close();	
		System.out.println("Data Inserted Succesfully");
	}

}
