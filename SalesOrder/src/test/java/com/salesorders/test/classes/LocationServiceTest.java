package com.salesorders.test.classes;

import com.salesorders.models.Location;
import com.salesorders.services.LocationService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


public class LocationServiceTest {
    private static LocationService locationService;

    @BeforeClass
    public static void setup() {
        locationService = new LocationService();
        TestDataProvider.initDatabase();
    }

    @AfterClass
    public static void teardown() {
        locationService = null;
    }

    // find all location
    @Test
    public void testFindAllLocations() {
        List<Location> locations = locationService.findAllLocations();
        for (Location location : locations) {
            System.out.println(location);
        }
    }

    // search a Asset with asset id
    @Test
    public void testfindALocationById() {
        Location location = locationService.findLocationById(1);
        System.out.println(location);
    }

    // Create a asset
    @Test
    public void testInsertLocation() {
       Location location = new Location("Big Fish Store","Karinty Frigzes ut 17");
       locationService.createLocation(location);
       
       location = locationService.findLastLocation();
       
       System.out.println(location);
    }
}
