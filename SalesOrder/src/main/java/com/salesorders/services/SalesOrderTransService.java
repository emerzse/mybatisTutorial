package com.salesorders.services;

import com.salesorders.mappers.SalesOrderTransMapper;
import com.salesorders.models.SalesOrderTrans;
import com.salesorders.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SalesOrderTransService {
    public List<SalesOrderTrans> findAllSalesOrderTrans() {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            SalesOrderTransMapper salesOrderTransMapper = sqlSession.getMapper(SalesOrderTransMapper.class);
            return salesOrderTransMapper.findAllSalesOrderTrans();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public SalesOrderTrans findLastSalesOrderTrans() {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            SalesOrderTransMapper salesOrderTransMapper = sqlSession.getMapper(SalesOrderTransMapper.class);
            return salesOrderTransMapper.findLastSalesOrderTrans();
        }
    }

    public SalesOrderTrans findASalesOrderTransById(Integer transID) {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            SalesOrderTransMapper salesOrderTransMapper = sqlSession.getMapper(SalesOrderTransMapper.class);
            return salesOrderTransMapper.findASalesOrderTransById(transID);
        }
    }

    public void createSalesOrderTrans(SalesOrderTrans salesOrderTans) {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            SalesOrderTransMapper salesOrderTransMapper = sqlSession.getMapper(SalesOrderTransMapper.class);
            salesOrderTransMapper.insertNewASalesOrderTrans(salesOrderTans);
            sqlSession.commit();
        }
    }
}
