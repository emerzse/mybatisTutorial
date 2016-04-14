package com.salesorders.models;

public class Location {
    private int locationId;
    private String name;
    private String address;
    
    public int getLocationId() {
        return locationId;
    }

    public void setId(int id) {
        this.locationId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Location() {
       
    }

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "Location:[id: "+locationId+", name: "+name+", address:"+address+"]";
    }
    
    
}
