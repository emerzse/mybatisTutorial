package com.salesorders.models;

import com.salesorders.services.AssetService;
import com.salesorders.services.LocationService;

public class SalesOrderTrans {
    private int transId;
    private int quantity;
    private double price;
    private String currency;
    private Asset item;
    private Location location;
    private int assetId, locationId;
    
    public int getTransid() {
        return transId;
    }

    public void setTransid(int transid) {
        transId = transid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Asset getItem() {
        return item;
    }

    public void setItem(Asset item) {
        this.item = item;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getAssetId() {
        return assetId;
    }

    public int getLocationId() {
        return locationId;
    }
    
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public static SalesOrderTrans initSalesOrderTrans(SalesOrderTrans salesOrderTrans){
        AssetService assetService;
        LocationService localtionService;
        if(salesOrderTrans.getItem() == null)
        {
            assetService = new AssetService();
            salesOrderTrans.setItem(assetService.findAssetById(salesOrderTrans.assetId));
            assetService = null;
        }
        
        if(salesOrderTrans.getLocation() == null)
        {
            localtionService = new LocationService();
            salesOrderTrans.setLocation(localtionService.findLocationById(salesOrderTrans.locationId));
            localtionService = null;
        }
        
        return salesOrderTrans;
    }

    public SalesOrderTrans() {
    }

    public SalesOrderTrans(Asset item, Location location, int quantity, double price) {
        super();
        this.quantity = quantity;
        this.price = price;
        this.item = item;
        this.location = location;
        this.locationId = location.getLocationId();
        this.assetId =  item.getAssetId();
    }
    
    public SalesOrderTrans(Asset item, Location location, int quantity, double price, String currency) {
        super();
        this.quantity = quantity;
        this.price = price;
        this.item = item;
        this.location = location;
        this.locationId = location.getLocationId();
        this.assetId =  item.getAssetId();
        this.currency = currency;
    }
    
    @Override
    public String toString() {
        return "SalesOrder:[transId:"+transId+" , item: "+item+", location: "+location+", quantity: "+quantity+", price: "+price+", currency: "+currency+"]";
    }


    
}
