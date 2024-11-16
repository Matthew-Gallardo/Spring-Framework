package org.acumen.training.codes.dao;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.acumen.training.codes.model.tables.Reservation;
import org.acumen.training.codes.model.tables.Reservation.ReservationPath;
import org.jooq.DSLContext;

public class ReservationDao {
	private DSLContext ctx;
	private static final Logger LOGGER = Logger.getLogger(ReservationDao.class.getName());
	
	public ReservationDao(DSLContext ctx) {
		this.ctx=ctx;
	}
	// insert
	public boolean insertReservation(Integer rid, Integer sid, Integer bid,LocalDate day){
		try {
			int rows = ctx.transactionResult((cfg)->{
				int count = cfg.dsl().insertInto(Reservation.RESERVATION)
						.set(Reservation.RESERVATION.RID, rid)
						.set(Reservation.RESERVATION.SID, sid)
						.set(Reservation.RESERVATION.BID, bid)
						.set(ReservationPath.RESERVATION.DAY, day)
						.execute();
				
				return count;
			});
			LOGGER.info("No of rows %d".formatted(rows));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//delete by id
	public boolean deleteReservationById(Integer rid){
		try {
			int rows = ctx.transactionResult((cfg)->{
				int count = cfg.dsl().deleteFrom(Reservation.RESERVATION)
						.where(Reservation.RESERVATION.RID.equal(rid))
						.execute();
				return count;
			});
			LOGGER.info("No of rows deleted %d".formatted(rows));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	   // Move all reservation dates for a specific boat to a new date
	public boolean updateReservationDates(int boatId, LocalDate newDate) {
	    try {
	        int rowsAffected = ctx.update(Reservation.RESERVATION)
	                .set(Reservation.RESERVATION.DAY, newDate)
	                .where(Reservation.RESERVATION.BID.eq(boatId))
	                .execute();
	        
	        LOGGER.info(String.format("Updated reservation dates for boat ID %d: %d rows affected", boatId, rowsAffected));
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        LOGGER.severe("Failed to update reservation dates for boat ID " + boatId + ": " + e.getMessage());
	        return false;
	    }
	}
	
	
	

}
