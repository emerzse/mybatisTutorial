package com.salesorders.services;

import com.salesorders.mappers.AssetMapper;
import com.salesorders.models.Asset;
import com.salesorders.models.ChildAsset;
import com.salesorders.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AssetService {
    public List<Asset> findAllAssets() {
        AssetMapper assettMapper;
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            assettMapper = sqlSession.getMapper(AssetMapper.class);
            return assettMapper.findAllAsset();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Asset findLastAsset() {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            AssetMapper assettMapper = sqlSession.getMapper(AssetMapper.class);
            return assettMapper.findLastAsset();
        }
    }
    
    public ChildAsset findLastChildAsset() {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            AssetMapper assettMapper = sqlSession.getMapper(AssetMapper.class);
            return assettMapper.findLastChildAsset();
        }
    }

    public Asset findAssetById(Integer assetId) {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            AssetMapper assettMapper = sqlSession.getMapper(AssetMapper.class);
            return assettMapper.findAAssetById(assetId);
        }
    }

    public void createAsset(Asset asset) {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            AssetMapper assettMapper = sqlSession.getMapper(AssetMapper.class);
            assettMapper.insertNewAsset(asset);
            sqlSession.commit();
        } 
    }
    
   public void createAsset(ChildAsset asset) {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            AssetMapper assettMapper = sqlSession.getMapper(AssetMapper.class);
            assettMapper.insertNewChildAsset(asset);
            sqlSession.commit();
        } 
    }
}
