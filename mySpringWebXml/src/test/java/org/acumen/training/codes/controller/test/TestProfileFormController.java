package org.acumen.training.codes.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml",
"file:src/main/webapp/WEB-INF/jdbcContext.xml"})
@Transactional(transactionManager = "txManager")
@WebAppConfiguration
public class TestProfileFormController {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@AfterEach
	public void teardown() {
		mockMvc = null;
	}

	@Test
	public void testGetProfileFormView()throws Exception{
		mockMvc.perform(get("/profile/form.html")).andDo(print()).andExpect(view().name("profileForm"));
	}
	
	@Test
	public void testGetProfileFormStatus() throws Exception {
	    mockMvc.perform(get("/profiles/form.html"))
	           .andDo(print())
	           .andExpect(status().isOk());
	}

	@Test
	public void testPostProfileFormStatus() throws Exception {
	    mockMvc.perform(post("/profile/form.html")
	            .formField("id", "123")
	            .formField("fullname", "Lebron James")
	            .formField("salary", "50000")
	            .formField("birthday", "1990-01-01")
	            .formField("color", "blue")
	            .formField("gender", "male")
	            .formField("food", "pizza", "pasta")) 
	            .andExpect(view().name("profileResult"));
	}


}
