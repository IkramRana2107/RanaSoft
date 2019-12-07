
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
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class SelectTwoFieldUsingProjections {
	public static void main(String args[])
	{
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml").build();
		Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=metadata.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Criteria c =s.createCriteria(Employee.class);
	    Projection p1=Projections.property("name");
	    Projection p2=Projections.property("email");
	    ProjectionList plist=Projections.projectionList();
	    plist.add(p1);
	    plist.add(p2);
	    c.setProjection(plist);
	    List<Object[]> list=c.list();
	    for(Object[] o:list)
	    {
	     System.out.println("Name "+o[0]);  // name
	     System.out.println("Email "+o[1]);  // email
	    }
		s.close();
		sf.close();	
	}

}

