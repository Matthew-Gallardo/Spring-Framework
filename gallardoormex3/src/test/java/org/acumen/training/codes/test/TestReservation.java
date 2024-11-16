package org.acumen.training.codes.test;

import java.time.LocalDate;

import org.acumen.training.codes.SailorConfiguration;
import org.acumen.training.codes.dao.ReservationDao;
import org.jooq.DSLContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReservation {
	private SailorConfiguration cfg;
	private DSLContext ctx;
	private ReservationDao reservationDao;
	
	@BeforeEach
	public void setup() {
		cfg = new SailorConfiguration();
		String url = "jdbc:postgresql://localhost:5432/sailor";
		String userName ="postgres";
		String password = "admin2255";
		ctx = cfg.createDSLContext(url, userName, password);
		reservationDao = new ReservationDao(ctx);
	}
	
	@AfterEach
	public void teardown() {
		cfg.closeConnection();
		cfg=null;
	}
	
	@Test
	public void testinsertSailor() {
		reservationDao.insertReservation(9, 58, 103, LocalDate.of(2024, 10, 28));
		
	}
	
	@Test
	public void testDeleteSailorById() {
		reservationDao.deleteReservationById(9);
	}
	
	@Test
	public void testUpdateReservationDates() {
		reservationDao.updateReservationDates(101, LocalDate.of(2008, 2, 8));
	}
}
