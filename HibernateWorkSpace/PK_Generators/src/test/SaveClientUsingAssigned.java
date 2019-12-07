package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import beans.BookMovie;

public class SaveClientUsingAssigned {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("resources/hibernate.cfg.xml")
				.build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		BookMovie m=new BookMovie();
	//	m.setId(3);
		m.setMovie("Sultan");
		m.setSeatno(26);
		m.setShowtime("1pm");
		s.save(m);
		t.commit();
		s.close();
		sf.close();
         System.out.println("Insertion Successfull");

	}

}
