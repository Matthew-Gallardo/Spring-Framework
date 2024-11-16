package org.acumen.training.codes.test;

import org.acumen.training.codes.SailorConfiguration;
import org.acumen.training.codes.dao.BoatDao;
import org.jooq.DSLContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBoatDao {
	private SailorConfiguration cfg;
	private DSLContext ctx;
	private BoatDao boatDao;
	
	@BeforeEach
	public void setup() {
		cfg = new SailorConfiguration();
		String url = "jdbc:postgresql://localhost:5432/sailor";
		String userName ="postgres";
		String password = "admin2255";
		ctx = cfg.createDSLContext(url, userName, password);
		boatDao = new BoatDao(ctx);
	}
	
	@AfterEach
	public void teardown() {
		cfg.closeConnection();
		cfg=null;
	}
	
	@Test
	public void testinsertSailor() {
		boatDao.insertBoat(105, "James", "violet");
		cfg.closeConnection();
	}
	
	@Test
	public void testDeleteSailorById() {
		boatDao.deleteBoatById(105);
		cfg.closeConnection();
	}
	
	@Test
	public void testRenameBoat() {
		boatDao.renameBoat("Interlake", "newName");
		cfg.closeConnection();
	}
}
