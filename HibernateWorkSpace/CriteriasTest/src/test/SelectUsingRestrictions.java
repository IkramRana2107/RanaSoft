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
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class SelectUsingRestrictions {
	public static void main(String args[])
	{
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml").build();
		Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=metadata.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Criteria c =s.createCriteria(Employee.class);
	//	Criterion cr=Restrictions.eq("id", 111);
		Criterion cr=Restrictions.gt("salary",60000);
		c.add(cr);
		List<Employee> emplist=c.list();
		/* Employee emp=(Employee)c.uniqueResult();
		System.out.println("EmployeeName="+emp.getName());
		System.out.println("EmployeeEmail="+emp.getEmail());
		System.out.println("EmployeeSalary="+emp.getSalary());*/
		for(Employee emp:emplist)
		{
			System.out.println(emp.getId());
			System.out.println(emp.getName());
			System.out.println(emp.getEmail());	
		}
		s.close();
		sf.close();	
	}

}

