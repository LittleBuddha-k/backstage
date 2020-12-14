package com.littlebuddha.backstage.modules.manager.entity;

import com.littlebuddha.backstage.common.base.DataEntity;

import java.util.Date;

/**
 * 厂商来料
 * @author ck
 * @date 2020/12/4 14:58
 */
public class MaterielFromSupplier extends DataEntity<MaterielFromSupplier> {

    private Integer serialNumber;                     //序号
    private Date inComingDate;                                //日期
    private String blueIslandMaterielNumber;          //蓝岸料号
    private String supplierMaterielNumber;            //供应商料号编码
    private String materielName;                      //物料名称
    private String description;                      //描述
    private Double goodProducts;                     //良品数
    private Double badProducts;                      //不良品数
    private String deliveryOrderNumber;              //送货单号
    private String deliveryManufacturerCheck;        //交货厂商核对
    private String blueIslandOrderNumber;            //蓝岸订单号

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getInComingDate() {
        return inComingDate;
    }

    public void setInComingDate(Date inComingDate) {
        this.inComingDate = inComingDate;
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

    public Double getGoodProducts() {
        return goodProducts;
    }

    public void setGoodProducts(Double goodProducts) {
        this.goodProducts = goodProducts;
    }

    public Double getBadProducts() {
        return badProducts;
    }

    public void setBadProducts(Double badProducts) {
        this.badProducts = badProducts;
    }

    public String getDeliveryOrderNumber() {
        return deliveryOrderNumber;
    }

    public void setDeliveryOrderNumber(String deliveryOrderNumber) {
        this.deliveryOrderNumber = deliveryOrderNumber;
    }

    public String getDeliveryManufacturerCheck() {
        return deliveryManufacturerCheck;
    }

    public void setDeliveryManufacturerCheck(String deliveryManufacturerCheck) {
        this.deliveryManufacturerCheck = deliveryManufacturerCheck;
    }

    public String getBlueIslandOrderNumber() {
        return blueIslandOrderNumber;
    }

    public void setBlueIslandOrderNumber(String blueIslandOrderNumber) {
        this.blueIslandOrderNumber = blueIslandOrderNumber;
    }
}
