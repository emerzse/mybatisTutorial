package com.salesorders.models;

public class ChildAsset extends Asset{

    private String childDescription;
    
    public ChildAsset() {
      super();
    }
    
    public ChildAsset(String name, String description, int sizeX, int sizeY, String color,
            String descripton) {
         super(name, description, sizeX, sizeY, color);
         this.childDescription = descripton;
     } 
    
    public String getDescripton() {
        return childDescription;
    }
    public void setDescripton(String descripton) {
        this.childDescription = descripton;
    }
    
    @Override
    public String toString() {
        String txtValue = super.toString();
        txtValue = txtValue.replace("]", " ");
        txtValue += ", descripton: "+childDescription+"]";
        
        return txtValue;
    }
}
