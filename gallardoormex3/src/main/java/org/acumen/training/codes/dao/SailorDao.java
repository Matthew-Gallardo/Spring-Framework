package org.acumen.training.codes.dao;

import java.util.List;
import java.util.logging.Logger;

import org.acumen.training.codes.model.tables.Boat;
import org.acumen.training.codes.model.tables.Reservation;
import org.acumen.training.codes.model.tables.Sailor;
import org.jooq.DSLContext;
import org.jooq.Record2;

public class SailorDao {
    private final DSLContext ctx;
    private static final Logger LOGGER = Logger.getLogger(SailorDao.class.getName());

    public SailorDao(DSLContext ctx) {
        this.ctx = ctx;
    }

    // Insert 
    public boolean insertSailor(Integer id, String name, Integer rating, Integer age) {
        try {
            int rows = ctx.transactionResult(cfg -> cfg.dsl().insertInto(Sailor.SAILOR)
                    .set(Sailor.SAILOR.ID, id)
                    .set(Sailor.SAILOR.NAME, name)
                    .set(Sailor.SAILOR.RATING, rating)
                    .set(Sailor.SAILOR.AGE, age)
                    .execute());
            LOGGER.info(String.format("Number of rows inserted: %d", rows));
            return rows > 0;
        } catch (Exception e) {
            LOGGER.severe("Failed to insert sailor: " + e.getMessage());
            return false;
        }
    }

    // Delete by ID
    public boolean deleteSailorById(Integer id) {
        try {
            int rows = ctx.transactionResult(cfg -> cfg.dsl().deleteFrom(Sailor.SAILOR)
                    .where(Sailor.SAILOR.ID.equal(id))
                    .execute());
            LOGGER.info(String.format("Number of rows deleted: %d", rows));
            return rows > 0;
        } catch (Exception e) {
            LOGGER.severe("Failed to delete sailor: " + e.getMessage());
            return false;
        }
    }

    //Sailors with a rating greater than a specific rate and age within a range
    public List<Record2<String, Integer>> findSailorsByRatingAndAge(int rate, int age1, int age2) {
        try {
            List<Record2<String, Integer>> results = ctx.select(Sailor.SAILOR.NAME, Sailor.SAILOR.AGE)
                    .from(Sailor.SAILOR)
                    .where(Sailor.SAILOR.RATING.gt(rate))
                    .and(Sailor.SAILOR.AGE.between(age1, age2))
                    .fetch();
            LOGGER.info(String.format("Found %d sailors with rating > %d and age between %d and %d", results.size(), rate, age1, age2));
            return results;
        } catch (Exception e) {
            LOGGER.severe("Failed to find sailors by rating and age: " + e.getMessage());
            return List.of();
        }
    }

    // rating and age of sailors who reserved a specific boat
    public List<Record2<Integer, Integer>> getRatingAndAgeForBoat(int boatId) {
        try {
            List<Record2<Integer, Integer>> results = ctx.select(Sailor.SAILOR.RATING, Sailor.SAILOR.AGE)
                    .from(Sailor.SAILOR)
                    .join(Reservation.RESERVATION)
                    .on(Sailor.SAILOR.ID.eq(Reservation.RESERVATION.SID))
                    .where(Reservation.RESERVATION.BID.eq(boatId))
                    .fetch();
            LOGGER.info(String.format("Found %d sailors who reserved boat ID %d", results.size(), boatId));
            return results;
        } catch (Exception e) {
            LOGGER.severe("Failed to get rating and age for boat ID " + boatId + ": " + e.getMessage());
            return List.of();
        }
    }

    //  IDs of sailors who reserved either boat1 or boat2
    public List<Integer> getSailorIdsForBoats(int boat1, int boat2) {
        try {
            List<Integer> sailorIds = ctx.selectDistinct(Sailor.SAILOR.ID)
                    .from(Sailor.SAILOR)
                    .join(Reservation.RESERVATION)
                    .on(Sailor.SAILOR.ID.eq(Reservation.RESERVATION.SID))
                    .where(Reservation.RESERVATION.BID.in(boat1, boat2))
                    .fetchInto(Integer.class);
            LOGGER.info(String.format("Found %d sailors who reserved either boat ID %d or %d", sailorIds.size(), boat1, boat2));
            return sailorIds;
        } catch (Exception e) {
            LOGGER.severe("Failed to get sailor IDs for boats " + boat1 + " and " + boat2 + ": " + e.getMessage());
            return List.of();
        }
    }

    // sailors who have reserved every red boat
    public List<Record2<Integer, String>> getSailorsReservedAllRedBoats() {
        try {
            List<Record2<Integer, String>> sailors = ctx.select(Sailor.SAILOR.ID, Sailor.SAILOR.NAME)
                    .from(Sailor.SAILOR)
                    .join(Reservation.RESERVATION)
                    .on(Sailor.SAILOR.ID.equal(Reservation.RESERVATION.SID))
                    .join(Boat.BOAT)
                    .on(Reservation.RESERVATION.BID.equal(Boat.BOAT.ID))
                    .where(Boat.BOAT.COLOUR.equal("red"))
                    .groupBy(Sailor.SAILOR.ID, Sailor.SAILOR.NAME)
             
                    .fetch();
            LOGGER.info(String.format("Found %d sailors who have reserved all red boats", sailors.size()));
            return sailors;
        } catch (Exception e) {
            LOGGER.severe("Failed to get sailors who reserved all red boats: " + e.getMessage());
            return List.of();
        }
    }
    

}
