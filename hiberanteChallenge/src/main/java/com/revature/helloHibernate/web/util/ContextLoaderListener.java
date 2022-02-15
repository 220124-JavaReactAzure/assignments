package com.revature.helloHibernate.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.helloHibernate.dao.DirectorDAO;
import com.revature.helloHibernate.models.Director;
import com.revature.helloHibernate.services.DirectorServices;
import com.revature.helloHibernate.web.servlets.DirectorServlet;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		DirectorDAO directorDAO = new DirectorDAO();
		DirectorServices directorServices = new DirectorServices(directorDAO);
		DirectorServlet directorServlet = new DirectorServlet(directorServices, mapper);
		
		ServletContext context = sce.getServletContext();
		context.addServlet("DirectorServlet", directorServlet).addMapping("/directors/*");
		
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
		
}
