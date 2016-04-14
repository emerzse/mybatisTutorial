package com.salesorders.mappers;

import com.salesorders.models.Location;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LocationMapper {
        @Select("Select * from Locations")
        @ResultMap("LocationResult")
        public List<Location> findAllLocations();

        @Select("select * from Locations where location_id=#{locationid}")
        @ResultMap("LocationResult")
        public Location findALocationById(int locationId);
        
        @Select("SELECt * FROM LOCATIONS ORDER BY LOCATION_ID DESC LIMIT 1")
        @ResultMap("LocationResult")
        public Location findLastLocation();

        @Insert("INSERT INTO LOCATIONS(NAME,ADDRESS) VALUES(#{name},#{address})")
        public void insertNewALocation(Location location);

}
