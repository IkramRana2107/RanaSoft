package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import beans.OldStudent;

public class ClientInsert {
	public static void main(String args[])
	{
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml").build();
		Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=metadata.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		OldStudent os1 =new OldStudent(111,"abc","abc@gmail.com","Delhi");
		OldStudent os2 =new OldStudent(222,"lmn","lmn@gmail.com","Mumbai");
		OldStudent os3 =new OldStudent(333,"xyz","xyz@gmail.com","Noida");
		s.save(os1);
		s.save(os2);
		s.save(os3);
		t.commit();
		s.close();
		sf.close();		
	}

}
