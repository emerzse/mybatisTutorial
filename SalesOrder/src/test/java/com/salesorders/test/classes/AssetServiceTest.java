package com.salesorders.test.classes;

import com.salesorders.models.Asset;
import com.salesorders.models.ChildAsset;
import com.salesorders.services.AssetService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class AssetServiceTest {
    private static AssetService assetService;

    @BeforeClass
    public static void setup() {
        assetService = new AssetService();
     //   TestDataProvider.initDatabase();
    }

    @AfterClass
    public static void teardown() {
        assetService = null;
    }

    // find all assets
    @Test
    public void testFindAllAssets() {
        List<Asset> assets = assetService.findAllAssets();
        for (Asset asset : assets) {
            System.out.println(asset);
        }
    }

    // search a Asset with asset id
    @Test
    public void testfindAssettById() {
        Asset asset = assetService.findAssetById(1);
        System.out.println(asset);
    }

    // Create a asset
    @Test
    public void testInsertAsset() {
       Asset asset = new Asset("chair", "small white chair", 5, 6, "purple");
       assetService.createAsset(asset);
       
       asset = assetService.findLastAsset();
       
       System.out.println(asset);
    }
    
    @Test
    public void testInsertChildAsset() {
       ChildAsset asset = new ChildAsset("chair", "small white chair", 5, 6, "white","~ helllloooo");
     //  assetService.createAsset(asset);
       
       asset = assetService.findLastChildAsset();
       
       System.out.println(asset);
    }
}
