package com.littlebuddha.backstage.modules.manager.entity;

import com.littlebuddha.backstage.common.base.DataEntity;

import java.util.Date;

/**
 * 其他出库
 * @author ck
 * @date 2020/12/4 15:46
 */
public class OtherOutWarehouse extends DataEntity<OtherOutWarehouse> {

    private Integer serialNumber;                     //序号
    private Date outWarehouseDate;                    //出库日期
    private String blueIslandMaterielNumber;          //蓝岸料号
    private String supplierMaterielNumber;            //供应商料号编码
    private String materielName;                      //物料名称
    private String description;                      //描述
    private Integer outWarehouseAmount;              //出库数量
    private String deliveryOrderNumber;              //送货单号

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getOutWarehouseDate() {
        return outWarehouseDate;
    }

    public void setOutWarehouseDate(Date outWarehouseDate) {
        this.outWarehouseDate = outWarehouseDate;
    }

    public String getBlueIslandMaterielNumber() {
        return blueIslandMaterielNumber;
    }

    public void setBlueIslandMaterielNumber(String blueIslandMaterielNumber) {
        this.blueIslandMaterielNumber = blueIslandMaterielNumber;
    }

    public String getSupplierMaterielNumber() {
        return supplierMaterielNumber;
    }

    public void setSupplierMaterielNumber(String supplierMaterielNumber) {
        this.supplierMaterielNumber = supplierMaterielNumber;
    }

    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOutWarehouseAmount() {
        return outWarehouseAmount;
    }

    public void setOutWarehouseAmount(Integer outWarehouseAmount) {
        this.outWarehouseAmount = outWarehouseAmount;
    }

    public String getDeliveryOrderNumber() {
        return deliveryOrderNumber;
    }

    public void setDeliveryOrderNumber(String deliveryOrderNumber) {
        this.deliveryOrderNumber = deliveryOrderNumber;
    }
}
