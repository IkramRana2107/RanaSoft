package test;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class SelectUsingProjections {
	public static void main(String args[])
	{
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml").build();
		Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=metadata.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Criteria c =s.createCriteria(Employee.class);
	    Projection p=Projections.property("name");
	    c.setProjection(p);
	    List<String> list=c.list();
	    for(String name:list)
	    {
	    	System.out.println(name);
	    }
		s.close();
		sf.close();	
	}

}

