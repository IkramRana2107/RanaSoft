package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SaveClient {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("resources/hibernate.cfg.xml")
				.build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session s = factory.openSession();
		Transaction t = s.beginTransaction();
		Student st = new Student();
		st.setId(111);
		st.setName("abc");
		st.setEmail("abc123@gmail.com");
		st.setAddress("hyderabad");
		s.merge(st);
		// Save can execute without transaction boundary
		// Persist can execute within transaction boundary
	//	System.out.println(pk);
		t.commit();  // Data will execute here
		s.close();
		factory.close();
		System.out.println("Data Inserted Successfully");

	}

}
