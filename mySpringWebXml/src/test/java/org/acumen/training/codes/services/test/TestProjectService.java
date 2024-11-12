package org.acumen.training.codes.services.test;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.lenient;


import java.time.LocalDate;

import org.acumen.training.codes.dao.ProjectDao;
import org.acumen.training.codes.model.data.Project;
import org.acumen.training.codes.model.form.ProjectForm;
import org.acumen.training.codes.services.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
@Transactional(transactionManager = "txManager")
@WebAppConfiguration
public class TestProjectService {

	@Mock
	private ProjectDao projectDao;
	
	@Mock
	private Project project;
	
	@InjectMocks 
	ProjectService projectService = new ProjectService();
	
	
	@Test
	public void testInsert() {

	}



	
}
