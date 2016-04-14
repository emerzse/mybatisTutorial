package com.salesorders.mappers;

import com.salesorders.models.SalesOrderTrans;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SalesOrderTransMapper {
    @Select("Select * from SALESORDERTRANS")
    @ResultMap("SalesOrderTransResult")
    public List<SalesOrderTrans> findAllSalesOrderTrans();

    @Select("select * from SALESORDERTRANS  where location_id=#{locationid}")
    @ResultMap("SalesOrderTransResult")
    public SalesOrderTrans findASalesOrderTransById(int transId);
    
    @Select("SELECt * FROM SALESORDERTRANS  ORDER BY TRANS_ID DESC LIMIT 1")
    @ResultMap("SalesOrderTransResult")
    public SalesOrderTrans findLastSalesOrderTrans();

   // @Insert("INSERT INTO SALESORDERTRANS (ASSETID,LOCATIONID,QUANTITY,PRICE) VALUES(#{assetId},#{locationId},#{quantity}, #{price})")
    public void insertNewASalesOrderTrans(SalesOrderTrans salesOrderTrans);
}
