package test;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import beans.Employee;

public class AggregateFunctionUsingProjection {
	public static void main(String args[])
	{
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml").build();
		Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=metadata.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Criteria c =s.createCriteria(Employee.class);
	   /* Projection p=Projections.avg("salary");
	    c.setProjection(p);
	    double avg_salary=(double)c.uniqueResult();
	    System.out.println("Average Salary="+avg_salary);// Average Salary */
		Projection p=Projections.max("salary");
	    c.setProjection(p);
	    int maxsalary=(Integer)c.uniqueResult();
	    System.out.println("Maximum Salary="+maxsalary); // Maximum Salary
		s.close();
		sf.close();	
	}

}


