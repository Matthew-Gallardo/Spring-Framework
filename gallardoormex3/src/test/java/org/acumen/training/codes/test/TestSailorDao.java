package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.acumen.training.codes.SailorConfiguration;
import org.acumen.training.codes.dao.SailorDao;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSailorDao {
    private SailorConfiguration cfg;
    private DSLContext ctx;
    private SailorDao sailorDao;

    @BeforeEach
    public void setup() {
        cfg = new SailorConfiguration();
        String url = "jdbc:postgresql://localhost:5432/sailor";
        String userName = "postgres";
        String password = "admin2255";
        ctx = cfg.createDSLContext(url, userName, password);
        sailorDao = new SailorDao(ctx);
    }

    @AfterEach
    public void teardown() {
    	cfg.closeConnection();
		cfg=null;
    }

    @Test
    public void testInsertSailor() {
        boolean result = sailorDao.insertSailor(60, "Kai", 10, 25);
        assertTrue(result, "Sailor should be inserted successfully.");
    }

    @Test
    public void testDeleteSailorById() {
        boolean result = sailorDao.deleteSailorById(60);
        assertTrue(result, "Sailor should be deleted successfully.");
    }

    @Test
    public void testFindSailorsByRatingAndAge() {
        List<Record2<String, Integer>> sailors = sailorDao.findSailorsByRatingAndAge(7, 20, 40);
        sailors.forEach(System.out::println);
    }

    @Test
    public void testGetRatingAndAgeForBoat() {
        List<Record2<Integer, Integer>> ratingAndAge = sailorDao.getRatingAndAgeForBoat(103);
        ratingAndAge.forEach(System.out::println);
    }

    @Test
    public void testGetSailorIdsForBoats() {
        List<Integer> sailorIds = sailorDao.getSailorIdsForBoats(103, 104);
        System.out.println("Boat IDs of who either reserved  boat1 or boat2.");
        sailorIds.forEach(System.out::println);
    }

    @Test
    public void testGetSailorsReservedAllRedBoats() {
        List<Record2<Integer, String>> sailors = sailorDao.getSailorsReservedAllRedBoats();
        sailors.forEach(System.out::println);
    }
}
