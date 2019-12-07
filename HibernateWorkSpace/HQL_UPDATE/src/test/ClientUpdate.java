package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ClientUpdate {
	public static void main(String args[])
	{
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml").build();
		Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=metadata.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		String hql=" update Student set name='xyz',email='xyz@gmail.com' where id=1 ";
		//String hql=" update Student set id='10' where id=1 "; we can update primary key using HQL
		Query q=s.createQuery(hql);
        int i=q.executeUpdate();
        System.out.println("updated row="+i);
		t.commit();
		s.close();
		sf.close();		
	}

}
