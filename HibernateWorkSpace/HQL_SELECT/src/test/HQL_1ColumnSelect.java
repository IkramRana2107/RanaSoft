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
	public class HQL_1ColumnSelect {
		public static void main(String ars[]) {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml")
					.build();
			Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sf = metadata.getSessionFactoryBuilder().build();
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			String hql ="select name from Employee ";
			Query q = s.createQuery(hql);
			List<String> list1 = q.list();
			for(String name:list1)
			{
				System.out.println(name);	
			}
			t.commit();
			s.close();
			sf.close();
		}
}
