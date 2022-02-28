package com.revature.helloHibernate.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.revature.helloHibernate.dao.DirectorDAO;
import com.revature.helloHibernate.models.Director;
import com.revature.helloHibernate.services.DirectorServices;


public class DirectorServiceTestSuite {

	DirectorServices sut;
	DirectorDAO mockDirDao;
	
	@Before
	public void testPrep() {
		mockDirDao = mock(DirectorDAO.class);
		sut = new DirectorServices(mockDirDao);
	}
	
	@Test
	public void test_isDirectorValid_givenValidUser() {
		Director validDirector = new Director("james","jones",10);
		when(mockDirDao.addDirector(validDirector)).thenReturn(validDirector);
		
		Director actualResult = sut.addDirector(validDirector);
		
		assertNotNull(actualResult);
		verify(mockDirDao, times(1)).addDirector(validDirector);
		
		
	}
	
}
