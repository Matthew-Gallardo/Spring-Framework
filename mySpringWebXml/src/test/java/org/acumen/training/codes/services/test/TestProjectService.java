package org.acumen.training.codes.services.test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.acumen.training.codes.model.data.Project;
import org.acumen.training.codes.model.form.ProjectForm;
import org.acumen.training.codes.services.ProjectService;
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
public class TestProjectService {


	
	@Autowired
	ProjectService projectService = new ProjectService();
	
	
	@Test
	public void testInsert() {
		ProjectForm form = new ProjectForm();
		form.setId(222);
		form.setProjectname("APP");
		form.setProjectdate(LocalDate.of(2030, 1, 1));
		
		boolean res = projectService.insertRecord(form);
		assertTrue(res);

	}
	
	@Test
	public void testRetrieve() {
		List<Project>recs = projectService.retrieveAll();
		System.out.println(recs);
		
	}



	
}
