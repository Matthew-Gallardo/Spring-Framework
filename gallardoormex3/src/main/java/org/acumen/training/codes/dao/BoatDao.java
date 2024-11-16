package org.acumen.training.codes.dao;

import java.util.logging.Logger;

import org.acumen.training.codes.model.tables.Boat;
import org.jooq.DSLContext;

public class BoatDao {
	private DSLContext ctx;
	private static final Logger LOGGER = Logger.getLogger(BoatDao.class.getName());
	
	public BoatDao(DSLContext ctx) {
		this.ctx=ctx;
	}
	//insert
	public boolean insertBoat(Integer id, String name, String colour){
		try {
			int rows = ctx.transactionResult((cfg)->{
				int count = cfg.dsl().insertInto(Boat.BOAT)
						.set(Boat.BOAT.ID, id)
						.set(Boat.BOAT.NAME, name)
						.set(Boat.BOAT.COLOUR, colour)
						.execute();
				
				return count;
			});
			LOGGER.info("No of rows inserted %d".formatted(rows));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//delete by id
	public boolean deleteBoatById(Integer id){
		try {
			int rows = ctx.transactionResult((cfg)->{
				int count = cfg.dsl().deleteFrom(Boat.BOAT)
						.where(Boat.BOAT.ID.equal(id))
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
	
	 // Rename a boat to a new name
	public boolean renameBoat(String currentName, String newName) {
	    try {
	        int rowsAffected = ctx.update(Boat.BOAT)
	                .set(Boat.BOAT.NAME, newName)
	                .where(Boat.BOAT.NAME.eq(currentName))
	                .execute();

	        LOGGER.info(String.format("Number of boats renamed from '%s' to '%s': %d", currentName, newName, rowsAffected));
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        LOGGER.severe("Failed to rename boat from '" + currentName + "' to '" + newName + "': " + e.getMessage());
	        return false;
	    }
	}
	
	

	
	

}
