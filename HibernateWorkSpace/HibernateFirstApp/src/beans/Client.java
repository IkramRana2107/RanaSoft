package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("resources/hibernate.cfg.xml").build();  
        
		   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session s = factory.openSession();  
		Transaction t = s.beginTransaction();   
		Student st=new Student();
		st.setId(6700);
		st.setName("ikram");
		st.setEmail("itsikramrana@gmail.com");
		st.setMarks(500);
		// Student object state is Transiant
		s.save(st);
		// Student object state is Persistent
		t.commit();
		// Student object Will move Database
		s.close();
		s.evict(st);
		// Student object Detached state
		// Student object Will be removed from persistent than GC will collect student object
		factory.close();
         System.out.println("Success");

	}

}
