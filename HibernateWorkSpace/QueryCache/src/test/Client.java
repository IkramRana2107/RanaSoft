package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import beans.Student;

public class Client {
	public static void main(String args[])
	{
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("resources/hibernate.cfg.xml").build();

	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

	SessionFactory sf = meta.getSessionFactoryBuilder().build();
	Session s = sf.openSession();
	Session s2 = sf.openSession();
	/*Using FirstSession*/
	Student st1 = (Student)s.get(Student.class, 13);
	System.out.println(st1.getName());
	System.out.println(st1.getEmail());
	/*Student st2 = (Student)s.get(Student.class, 13);
	System.out.println(st2.getName());
	System.out.println(st2.getEmail());*/
	/*Using Second Session*/
	Student st3 = (Student)s2.get(Student.class, 13);
	System.out.println(st3.getName());
	System.out.println(st3.getEmail());
	
	}
}
