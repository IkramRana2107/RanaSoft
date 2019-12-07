package controller;

import java.io.IOException;

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

import beans.ICICIBean;

public class ICICIServlet extends HttpServlet {
	SessionFactory sf;
	public void init()
	{
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("resources/oracle.cfg.xml").build();
		Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
		sf=metadata.getSessionFactoryBuilder().build();	
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phone"));
        int balance=Integer.parseInt(req.getParameter("balance"));
        ICICIBean icici=new ICICIBean(null,name,email,phone,balance);
        Session s=sf.openSession();
        Transaction t=s.beginTransaction();
       String ac =(String)s.save(icici);
       t.commit();
       s.close();
       res.getWriter().println("ID= "+ac);
       
        
}
	public void destroy()
	{
		sf.close();
	}
}
