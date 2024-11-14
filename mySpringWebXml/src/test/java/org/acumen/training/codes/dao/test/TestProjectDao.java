package org.acumen.training.codes.dao.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.acumen.training.codes.dao.ProjectDao;
import org.acumen.training.codes.model.data.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;



@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml",
"file:src/main/webapp/WEB-INF/jdbcContext.xml"})
@Transactional(transactionManager = "txManager")
@Rollback(value = true)
@WebAppConfiguration
public class TestProjectDao {
	

	
	@Autowired
	private ProjectDao dao;
	
	private Project proj;
	

	@BeforeEach
	public void setup() {
		proj = new Project();	
	}

	
	@Test
	public void insertProject() {
		proj.setId((short) 69);
		proj.setProjname("Test App");
		proj.setProjdate(LocalDate.of(2029, 1, 1));
		
		boolean res= dao.insertProject(proj);
		assertTrue(res);
	}
	@Test
	public void testSelectAll() {
		List<Project>recs = dao.selectAllProjects();
		System.out.println(recs);
		
	}

	
	

}
