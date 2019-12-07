package test;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import beans.Employee;

public class HQL_SelectAll {
	public static void main(String ars[]) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		String hql = " from Employee ";
		Query q = s.createQuery(hql);
		List<Employee> list1 = q.list();
		for (Employee emp : list1) {
			System.out.println("ID="+emp.getId()); // id
			System.out.println("NAME="+emp.getName()); // name
			System.out.println("EMAIL="+emp.getEmail()); // email
			System.out.println("SALARY="+emp.getSalary()); // salary
		}
		t.commit();
		s.close();
		sf.close();
	}
}
