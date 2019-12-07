package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class StudentRegServlet extends HttpServlet {
	SessionFactory sf;
    public void init(ServletConfig config) throws ServletException
    {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("resources/hibernate.cfg.xml").build();  
        
		   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		 sf = meta.getSessionFactoryBuilder().build(); 
    	System.out.println("session factory init");	
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		int marks=Integer.parseInt(req.getParameter("marks"));
		Student st=new Student(0,name,email,marks);
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		int pk=(Integer)s.save(st);
		t.commit();
		s.close();
		res.getWriter().println("registration successfull id= "+pk);

	}
	public void destroy()
	{
		sf.close();
	}
	}


