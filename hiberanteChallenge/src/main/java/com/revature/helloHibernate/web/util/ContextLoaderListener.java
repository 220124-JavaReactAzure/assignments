package com.revature.helloHibernate.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.revature.helloHibernate.dao.DirectorDAO;
import com.revature.helloHibernate.dao.MovieDAO;
import com.revature.helloHibernate.models.Director;
import com.revature.helloHibernate.services.DirectorServices;
import com.revature.helloHibernate.services.MovieServices;
import com.revature.helloHibernate.web.servlets.DirectorServlet;
import com.revature.helloHibernate.web.servlets.MovieServlet;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		
		DirectorDAO directorDAO = new DirectorDAO();
		DirectorServices directorServices = new DirectorServices(directorDAO);  // manual wiring
		DirectorServlet directorServlet = new DirectorServlet(directorServices, mapper);
		
		MovieDAO movieDAO = new MovieDAO();
		MovieServices movieServices = new MovieServices(movieDAO);
		MovieServlet movieServlet = new MovieServlet(movieServices, directorServices, mapper);
		
		ServletContext context = sce.getServletContext();
		context.addServlet("DirectorServlet", directorServlet).addMapping("/directors/*");
		context.addServlet("MovieServlet", movieServlet).addMapping("/movies/*");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
		
}
