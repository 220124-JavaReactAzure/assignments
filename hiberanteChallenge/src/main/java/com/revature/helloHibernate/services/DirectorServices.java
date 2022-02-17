package com.revature.helloHibernate.services;

import java.util.List;

import com.revature.helloHibernate.dao.DirectorDAO;
import com.revature.helloHibernate.models.Director;

public class DirectorServices {
	private final DirectorDAO directorDAO;
	
	public DirectorServices(DirectorDAO directorDAO) {
		this.directorDAO = directorDAO;
	}
	
	public boolean addDirector(Director director) {
		
		return directorDAO.addDirector(director);
	}
	
	public List<Director> getAllDirectors(){
		return directorDAO.getAllDirectors();
		
	}
	
	public Director getDirectorById(int id){
		Director director = directorDAO.getDirectorById(id);
		return directorDAO.getDirectorById(id);
	}
	
	
	public void updateDirectorWithSessionMethod(Director director) {
		
		directorDAO.updateDirectorWithSessionMethod(director);
	}
	
	public void updateDirectorWithHQL(Director director) {
		
		directorDAO.updateDirectorWithHQL(director);
	}
	
	
}
