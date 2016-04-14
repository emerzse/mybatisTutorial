package com.salesorders.test.models;

import com.salesorders.models.Asset;
import com.salesorders.models.ChildAsset;
import com.salesorders.models.Location;
import com.salesorders.models.SalesOrderTrans;
import org.junit.Test;

public class TestModels {
 //   Asset asset;
 //   Location location;
    
//    @BeforeClass
//    public void setupParameters(){
////        asset = new Asset(1, "Easter egg", "choclate egg", 5, 6, "red");
////        location = new Location(1, "BigStore", "Elm st 13");
//        canCostructAAsset();
//        canCostructALoacation();
//    }
    
    @Test
    public void canCostructAAsset(){
        Asset asset = new Asset("chair", "small white chair", 5, 6, "white");
        System.out.println(asset);
    }
    
    @Test
    public void canCostructAChildAsset(){
        ChildAsset asset = new ChildAsset("dry Food", "1 selected dry foog", 4, 23, "Black", "Childeren");
        System.out.println(asset);
        Asset passet = new Asset("chair", "small white chair", 5, 6, "white");
        System.out.println(passet);
        ChildAsset lasset = new ChildAsset("dry Food", "1 selected dry foog", 4, 23, "Pink", "Childeren");
        System.out.println(lasset);
    }
    
    @Test
    public void canCostructALoacation(){
        Location location = new Location("BigStore", "Elm st 13");
        System.out.println(location);
    }
    
    @Test
    public void canConstructASalesOrderTrans(){
        Asset asset = new Asset("chair", "small white chair", 5, 6, "white");
        Location location = new Location("BigStore", "Elm st 13");
        SalesOrderTrans salesOrderTrans = new SalesOrderTrans(asset, location,1, 100);
        System.out.println(salesOrderTrans);
    }
}
