package com.salesorders.test.classes;

import com.salesorders.models.Asset;
import com.salesorders.models.Location;
import com.salesorders.models.SalesOrderTrans;
import com.salesorders.services.AssetService;
import com.salesorders.services.LocationService;
import com.salesorders.services.SalesOrderTransService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class SalesOrderTransServiceTest {
    private static SalesOrderTransService salesOrderTransService;
    private static AssetService assetService;
    private static LocationService locationService;

    @BeforeClass
    public static void setup() {
        salesOrderTransService = new SalesOrderTransService();
        assetService           = new AssetService();
        locationService        = new LocationService();
        
       // TestDataProvider.initDatabase();
    }

    @AfterClass
    public static void teardown() {
        salesOrderTransService = null;
        assetService = null;
        locationService = null;
    }

    // find all SalesOrderTrans
    @Test
    public void testFindAllSalesOrderTrans() {
        List<SalesOrderTrans> salesOrderTranslist = salesOrderTransService.findAllSalesOrderTrans();
        for (SalesOrderTrans salesOrderTrans : salesOrderTranslist) {
            System.out.println(salesOrderTrans);
        }
    }

    // search a SalesOrderTrans with asset id
    @Test
    public void testFindASalesOrderTransById() {
        SalesOrderTrans salesOrderTrans = salesOrderTransService.findASalesOrderTransById(1);
        System.out.println(salesOrderTrans);
    }

    // Create a SalesOrderTrans
    @Test
    public void testcreateSalesOrderTrans() {
       Asset asset = assetService.findAssetById(5);
       Location location = locationService.findLocationById(1);
       SalesOrderTrans salesOrderTrans = new SalesOrderTrans(asset,location,5,200);
       salesOrderTransService.createSalesOrderTrans(salesOrderTrans);
       
       salesOrderTrans = SalesOrderTrans.initSalesOrderTrans(salesOrderTransService.findLastSalesOrderTrans());
       
       System.out.println(salesOrderTrans);
    }
}
