package com.revature.helloHibernate.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.helloHibernate.models.Director;
import com.revature.helloHibernate.util.HibernateUtil;

public class DirectorDAO {
	public Director addDirector(Director director) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(director);
			return director;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return director;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<Director> getAllDirectors() {
		try {
			Session session = HibernateUtil.getSession();
			List<Director> directors = session.createQuery("FROM Director").list();
			return directors;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public Director getDirectorById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Director director = session.get(Director.class, id);
			return director;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateDirectorWithSessionMethod(Director director) {
		try {
			Session session = HibernateUtil.getSession();
			// Updates and Deletes always start with a transaction and end with a commit
			Transaction transaction = session.beginTransaction();
			session.merge(director);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}

	}
// Not truly implemented
	public void updateDirectorWithHQL(Director director) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
//			Query query = session.createQuery("update Director set email='" + director.getEmail() + 
//					"', first_name='" + director.getFirstName() + 
//					"', last_name='" + director.getLastName() + 
//					"', year_born=" + director.getYearBorn() +
//					" WHERE director_id=" + director.getId());
			
			Query query = session.createQuery("update Director set email= :email, first_name= :firstName, last_name= :lastName, year_born=:yearBorn where director_id = :id");
			//query.setParameter("email", director.getEmail());
			query.executeUpdate();
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		
	}

	public void deleteDirector(int id) {
		try {
			Session session = HibernateUtil.getSession();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
