package com.revature.helloHibernate.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.helloHibernate.models.Director;
import com.revature.helloHibernate.models.Movie;
import com.revature.helloHibernate.services.DirectorServices;
import com.revature.helloHibernate.services.MovieServices;

// TODO: Implement me
public class MovieServlet extends HttpServlet{

	private final MovieServices movieServices;
	private final ObjectMapper mapper;
	private final DirectorServices directorServices;
	
	public MovieServlet(MovieServices movieServices, DirectorServices directorServices, ObjectMapper mapper) {
		this.movieServices = movieServices;
		this.mapper = mapper;
		this.directorServices = directorServices;
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
				String idParam = req.getParameter("movieId");
				if(idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?movieId=# in your url");
					return;
				}
				
				int movieId = Integer.valueOf(idParam);
				
				Movie movie = movieServices.getMovieById(movieId);
				if(movie == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(movie);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<Movie> movies = movieServices.getAllMovies();
			String payload = mapper.writeValueAsString(movies);
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			String idParam = req.getParameter("directorId");
			if(idParam == null) {
				resp.setStatus(400);
				resp.getWriter().write("Please include the query ?directorId=# in your url");
				return;
			}
			Director director = directorServices.getDirectorById(Integer.valueOf(idParam));
			Movie newMovie = mapper.readValue(req.getInputStream(), Movie.class);
			newMovie.setDirector(director);
			movieServices.insertMovie(newMovie);
			resp.setStatus(201);
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
			Movie updatedMovie = mapper.readValue(req.getInputStream(), Movie.class);
			movieServices.updateMovieWithSessionMethod(updatedMovie);
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
}
