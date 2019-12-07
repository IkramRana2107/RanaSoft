package test;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import beans.Employee;

public class SelectAll {
	public static void main(String args[])
	{
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml").build();
		Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=metadata.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Criteria c =s.createCriteria(Employee.class);
		List<Employee> list=c.list();
		for(Employee e:list)
		{
		System.out.println("EmployeID="+e.getId());
		System.out.println("EmployeName="+e.getName());
		System.out.println("EmployeEmail="+e.getEmail());
		System.out.println("EmployeSalary="+e.getSalary());
		}
		s.close();
		sf.close();	
	}

}
