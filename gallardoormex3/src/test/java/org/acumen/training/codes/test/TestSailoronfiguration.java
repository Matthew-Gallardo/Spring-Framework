package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.acumen.training.codes.SailorConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSailoronfiguration {
	private SailorConfiguration cfg;
	
	@BeforeEach
	public void setup() {
		cfg = new SailorConfiguration();
	}
	
	@AfterEach
	public void teardown() {
		cfg = new SailorConfiguration();
	}
	
	@Test
	public void testConnection() {
		String url = "jdbc:postgresql://localhost:5432/sailor";
		String userName ="postgres";
		String password = "admin2255";
		assertNotNull(cfg.createDSLContext(url, userName, password));
		cfg.closeConnection();
		System.out.println("Database Connected");
	}

}
