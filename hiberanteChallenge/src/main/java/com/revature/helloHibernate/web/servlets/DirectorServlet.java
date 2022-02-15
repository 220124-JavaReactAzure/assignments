package com.revature.helloHibernate.web.servlets;

import javax.servlet.http.HttpServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.helloHibernate.services.DirectorServices;


public class DirectorServlet extends HttpServlet{

	
	private final DirectorServices directorServices;
	private final ObjectMapper mapper;
	
	public DirectorServlet(DirectorServices directorServices, ObjectMapper mapper) {
		this.directorServices = directorServices;
		this.mapper = mapper;
	}
	
	//TODO: Implement the servlet calls
}
