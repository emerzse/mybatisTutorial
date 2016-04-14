package com.salesorders.mappers;

import com.salesorders.models.Asset;
import com.salesorders.models.ChildAsset;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AssetMapper {
@Select("Select * from Assets")
@ResultMap("AssetResult")
public List<Asset> findAllAsset();

@Select("select * from Assets where asset_id=#{assetId}")
@ResultMap("AssetResult")
public Asset findAAssetById(int assetId);

@Select("SELECt * FROM ASSETS ORDER BY ASSET_ID DESC LIMIT 1")
/* this annotatiob same @ResultMap just longer and @resultmap use xml AssetMapper.xml
@Results({
    @Result(property = "assetId", column = "asset_Id"),
    @Result(property = "name", column = "name"),
    @Result(property = "description", column = "description"),
    @Result(property = "sizeX", column = "sizex"),
    @Result(property = "sizeY", column = "sizey"),
    @Result(property = "color", column = "color")
})*/
@ResultMap("AssetResult")
public Asset findLastAsset();

@Select("SELECt * FROM ASSETS WHERE (ASSETTYPE = 'CHILDASSET')  ORDER BY ASSET_ID DESC LIMIT 1")
@ResultMap("ChildResult")
public ChildAsset findLastChildAsset();

@Insert("INSERT INTO ASSETS(NAME,DESCRIPTION,SIZEX,SIZEY,COLOR,ASSETTYPE) VALUES(#{name},#{description},#{sizeX}, #{sizeY},#{color},#{assetType})")
public void insertNewAsset(Asset asset);



@Select("Select * from ASSETS")
@ResultMap("ChildResult")
public void selectallChild();

@Insert("INSERT INTO ASSETS(NAME,DESCRIPTION,SIZEX,SIZEY,COLOR,ASSETTYPE,CHILD_DESCRIPTION) VALUES(#{name},#{description},#{sizeX}, #{sizeY},#{color}, #{assetType},#{childDescription})")
public void insertNewChildAsset(ChildAsset asset);

}


