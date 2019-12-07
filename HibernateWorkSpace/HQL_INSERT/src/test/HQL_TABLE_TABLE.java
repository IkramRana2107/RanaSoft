package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import beans.OldStudent;

public class HQL_TABLE_TABLE {

	public static void main(String[] args)
		{
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml").build();
			Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sf=metadata.getSessionFactoryBuilder().build();
			Session s=sf.openSession();
			Transaction t=s.beginTransaction();
			String hql="insert into NewStudent(id,name,email,address) select  s.id,s.name,s.email,s.address from OldStudent s ";
			Query q=s.createQuery(hql);
			int i=q.executeUpdate();
			System.out.println("Numbers of rows dumped from Oldstudent to Newstudent table="+i);
			t.commit();
			s.close();
			sf.close();		
		}

	}

