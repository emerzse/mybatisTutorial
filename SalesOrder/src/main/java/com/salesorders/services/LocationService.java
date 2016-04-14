package com.salesorders.services;

import com.salesorders.mappers.LocationMapper;
import com.salesorders.models.Location;
import com.salesorders.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class LocationService {
    public List<Location> findAllLocations() {
        LocationMapper locationMapper;
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            locationMapper = sqlSession.getMapper(LocationMapper.class);
            return locationMapper.findAllLocations();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Location findLastLocation() {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            LocationMapper locationMapper = sqlSession.getMapper(LocationMapper.class);
            return locationMapper.findLastLocation();
        }
    }

    public Location findLocationById(Integer locationId) {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            LocationMapper locationMapper = sqlSession.getMapper(LocationMapper.class);
            return locationMapper.findALocationById(locationId);
        }
    }

    public void createLocation(Location location) {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            LocationMapper locationMapper = sqlSession.getMapper(LocationMapper.class);
            locationMapper.insertNewALocation(location);
            sqlSession.commit();
        }
    }
}
