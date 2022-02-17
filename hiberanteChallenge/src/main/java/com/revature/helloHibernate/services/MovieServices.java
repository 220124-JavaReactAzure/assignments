package com.revature.helloHibernate.services;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.helloHibernate.dao.MovieDAO;
import com.revature.helloHibernate.models.Movie;
import com.revature.helloHibernate.util.HibernateUtil;

//TODO: Implement me
public class MovieServices {
	
	private final MovieDAO movieDAO;
	
	public MovieServices(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}
	
	public void insertMovie(Movie movie) {
		movieDAO.insertMovie(movie);
	}

	public List<Movie> getAllMovies() {
		return movieDAO.getAllMovies();
	}

	public Movie getMovieById(int id) {
		
		Movie movie = movieDAO.getMovieById(id);
		return movie;
	}

	public List<Movie> getMoviesByDirectorId(int id) {
		return movieDAO.getMoviesByDirectorId(id);
	}

	// Using session method to update
	public void updateMovieWithSessionMethod(Movie movie) {
		movieDAO.updateMovieWithSessionMethod(movie);
	}

	// Using HQL to update
	public void updateMovieWithHQL(Movie movie) {
		movieDAO.updateMovieWithHQL(movie);
	}
}
