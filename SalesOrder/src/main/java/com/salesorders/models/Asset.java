package com.salesorders.models;

public class Asset {
    protected int assetId;
    protected String name;
    protected String description;
    protected int sizeX, sizeY;
    protected String color;
    protected AssetType assetType;
    
    public Asset() {
        this.initType();
    }

    public Asset(String name, String description, int sizeX, int sizeY, String color) {
        this.initType();
        this.name = name;
        this.description = description;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.color = color;
    }
    
    
    private void initType(){
        switch(this.getClass().getName())
        {
            case "com.salesorders.models.ChildAsset":
                assetType = AssetType.CHILDASSET;
                break;
            default : 
                assetType = AssetType.PARRENTASSET;
        }
    }
    
    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Asset:[assetid:"+assetId+", assetType: "+assetType+", name: "+name+", description: "+description+", size: ("+sizeX+","+sizeY+"), color: "+color+"]";
    }
    
    
}
