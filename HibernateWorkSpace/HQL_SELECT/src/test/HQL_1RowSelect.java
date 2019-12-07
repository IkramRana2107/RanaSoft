package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import beans.Employee;

public class HQL_1RowSelect {
	public static void main(String ars[]) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		String hql = "from Employee where id='222' ";
		Query q = s.createQuery(hql);
		Employee emp = (Employee)q.uniqueResult();
		System.out.println("ID " +emp.getId());
		System.out.println("NAME=" +emp.getName());
		System.out.println("EMAIL=" +emp.getEmail());
		System.out.println("Salary=" +emp.getSalary());
		t.commit();
		s.close();
		sf.close();
	}
}