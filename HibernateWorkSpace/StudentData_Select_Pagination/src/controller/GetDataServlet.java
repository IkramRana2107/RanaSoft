package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class GetDataServlet extends HttpServlet {
	SessionFactory sf;
    public void init(ServletConfig config) throws ServletException
    {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("resources/hibernate.cfg.xml").build();  
        
		   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		 sf = meta.getSessionFactoryBuilder().build(); 
    	System.out.println("session factory init");	
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out =res.getWriter();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		int fr =Integer.parseInt(req.getParameter("fr"));
		int mr=Integer.parseInt(req.getParameter("mr"));
		Query q=s.createQuery("From Student"); // Using HQL
		q.setFirstResult(fr);
		q.setMaxResults(mr);
		List<Student> list=q.list();
		for(Student st:list)
		{
			out.println("Id="+st.getId()+"\t Name="+st.getName()+"\t Email="+st.getEmail());
		}
		t.commit();
		s.close();
	}
	public void destroy()
	{
		sf.close();
	}
	}


