package org.acumen.training.codes.dao.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.acumen.training.codes.dao.ProjectDao;
import org.acumen.training.codes.model.data.Project;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;



@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
@Transactional(transactionManager = "txManager")
public class TestProjectDao {
	
	@Autowired
	private EntityManager em;
	
	private ProjectDao dao;
	private Project proj;
	

	@BeforeEach
	public void setup() {
		dao= new ProjectDao();
		proj = new Project();
		MockitoAnnotations.openMocks(this);
	}
	@AfterEach
	public void teardown() {
		dao = null;
	}
	
	@Test
	public void insertProject() {
		proj.setId((short) 69);
		proj.setProjname("");
		proj.setProjdate(LocalDate.of(2029, 1, 1));
		
		boolean res= dao.insertProject(proj);
		assertTrue(res);
		Mockito.verify(em).persist(proj);
		
	}

	
	

}
