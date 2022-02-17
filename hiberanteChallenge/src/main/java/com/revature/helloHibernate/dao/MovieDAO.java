package com.revature.helloHibernate.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.helloHibernate.models.Movie;
import com.revature.helloHibernate.util.HibernateUtil;

public class MovieDAO {
	// Implement these
	public void insertMovie(Movie movie) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(movie);
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<Movie> getAllMovies() {
		try {
			Session session = HibernateUtil.getSession();
			List<Movie> movieList = session.createQuery("FROM Movie").list();
			return movieList;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public Movie getMovieById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Movie movie = session.get(Movie.class, id);
			return movie;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<Movie> getMoviesByDirectorId(int id) {
		try {
			Session session = HibernateUtil.getSession();

			Query query = session.createQuery("FROM Movie m WHERE m.director.id = :ID");

			query.setParameter("ID", id);

			List<Movie> movieList = query.getResultList();

			return movieList;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	// Using session method to update
	public void updateMovieWithSessionMethod(Movie movie) {
		try {
			Session session = HibernateUtil.getSession();

			Transaction transaction = session.beginTransaction();

			session.merge(movie);

			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}

	}

	// Using HQL to update
	public void updateMovieWithHQL(Movie movie) {
		try {
			Session session = HibernateUtil.getSession();

			Transaction transaction = session.beginTransaction();
			Query query = session
					.createQuery("UPDATE Movie SET title = '" + movie.getTitle() + "' WHERE id = " + movie.getId());

			query.executeUpdate();

			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}

	}
}
