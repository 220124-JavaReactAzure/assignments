package com.revature.helloHibernate.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.helloHibernate.models.Director;
import com.revature.helloHibernate.services.DirectorServices;




public class DirectorServlet extends HttpServlet{
	
	private final DirectorServices directorServices;
	private final ObjectMapper mapper;
	
	public DirectorServlet(DirectorServices directorServices, ObjectMapper mapper) {
		this.directorServices = directorServices;
		this.mapper = mapper;
	}
	
	// RCUD - order
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Switch statements are back sorry
		PrintWriter writer = resp.getWriter();
		// Obtains everything after the /directors
		String path = req.getPathInfo();
		if(path == null) path = "";
		switch(path) {
		case "/ID":
			try {
				String idParam = req.getParameter("directorId");
				if(idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?directorId=# in your url");
					return;
				}
				
				int directorId = Integer.valueOf(idParam);
				
			
				Director director = directorServices.getDirectorById(directorId);
				if(director == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(director);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<Director> directors = directorServices.getAllDirectors();
			String payload = mapper.writeValueAsString(directors);
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			Director newDirector = mapper.readValue(req.getInputStream(), Director.class);
			boolean wasReg = directorServices.addDirector(newDirector);
			if(wasReg) {
				resp.setStatus(201);
			} else {
				resp.setStatus(500);
				resp.getWriter().write("Database did not persist");
			}
		} catch (StreamReadException | DatabindException e) {
			resp.setStatus(400);
			resp.getWriter().write("JSON threw exception");
			e.printStackTrace();
		} catch (Exception e) {
			resp.setStatus(500);
			resp.getWriter().write("Some other random exception did not persist");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Director updatedDirector = mapper.readValue(req.getInputStream(), Director.class);
			//directorServices.updateDirectorWithHQL(updatedDirector);
			directorServices.updateDirectorWithSessionMethod(updatedDirector);
			resp.setStatus(204);	
		} catch (StreamReadException | DatabindException e) {
			resp.setStatus(400);
			resp.getWriter().write("JSON threw exception");
			e.printStackTrace();
		} catch (Exception e) {
			resp.setStatus(500);
			resp.getWriter().write("Some other random exception did not persist");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
}
