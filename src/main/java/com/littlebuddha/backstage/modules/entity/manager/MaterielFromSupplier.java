package com.littlebuddha.backstage.modules.entity.manager;

import com.littlebuddha.backstage.common.anotations.ExcelField;
import com.littlebuddha.backstage.modules.base.DataEntity;

import java.util.Date;

/**
 * 厂商来料
 * @author ck
 * @date 2020/12/4 14:58
 */
public class MaterielFromSupplier extends DataEntity<MaterielFromSupplier> {

    private Integer serialNumber;                     //序号
    private Date inComingDate;                        //进货日期
    private String blueIslandMaterielNumber;          //蓝岸料号
    private String supplierMaterielNumber;            //供应商料号编码
    private String materielName;                      //物料名称
    private String description;                      //描述
    private Double goodProducts;                     //良品数
    private Double badProducts;                      //不良品数
    private String deliveryOrderNumber;              //送货单号
    private String deliveryManufacturerCheck;        //交货厂商核对
    private String blueIslandOrderNumber;            //蓝岸订单号

    @ExcelField(title = "序号",align = 2,sort = 1)
    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    @ExcelField(title = "日期",align = 2,sort = 2)
    public Date getInComingDate() {
        return inComingDate;
    }

    public void setInComingDate(Date inComingDate) {
        this.inComingDate = inComingDate;
    }

    @ExcelField(title = "蓝岸料号",align = 2,sort = 3)
    public String getBlueIslandMaterielNumber() {
        return blueIslandMaterielNumber;
    }

    public void setBlueIslandMaterielNumber(String blueIslandMaterielNumber) {
        this.blueIslandMaterielNumber = blueIslandMaterielNumber;
    }

    @ExcelField(title = "供应商料号编码",align = 2,sort = 4)
    public String getSupplierMaterielNumber() {
        return supplierMaterielNumber;
    }

    public void setSupplierMaterielNumber(String supplierMaterielNumber) {
        this.supplierMaterielNumber = supplierMaterielNumber;
    }

    @ExcelField(title = "物料名称",align = 2,sort = 5)
    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    @ExcelField(title = "描述",align = 2,sort = 6)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ExcelField(title = "良品数",align = 2,sort = 7)
    public Double getGoodProducts() {
        return goodProducts;
    }

    public void setGoodProducts(Double goodProducts) {
        this.goodProducts = goodProducts;
    }

    @ExcelField(title = "不良品数",align = 2,sort = 8)
    public Double getBadProducts() {
        return badProducts;
    }

    public void setBadProducts(Double badProducts) {
        this.badProducts = badProducts;
    }

    @ExcelField(title = "送货单号",align = 2,sort = 9)
    public String getDeliveryOrderNumber() {
        return deliveryOrderNumber;
    }

    public void setDeliveryOrderNumber(String deliveryOrderNumber) {
        this.deliveryOrderNumber = deliveryOrderNumber;
    }

    @ExcelField(title = "交货厂商核对",align = 2,sort = 10)
    public String getDeliveryManufacturerCheck() {
        return deliveryManufacturerCheck;
    }

    public void setDeliveryManufacturerCheck(String deliveryManufacturerCheck) {
        this.deliveryManufacturerCheck = deliveryManufacturerCheck;
    }

    @ExcelField(title = "蓝岸订单号",align = 2,sort = 11)
    public String getBlueIslandOrderNumber() {
        return blueIslandOrderNumber;
    }

    public void setBlueIslandOrderNumber(String blueIslandOrderNumber) {
        this.blueIslandOrderNumber = blueIslandOrderNumber;
    }
}
