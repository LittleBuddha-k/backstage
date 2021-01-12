package com.littlebuddha.backstage.modules.manager.entity;

import com.littlebuddha.backstage.common.anotations.ExcelField;
import com.littlebuddha.backstage.modules.base.DataEntity;

/**
 * 只依bom明细的统计
 * @author ck
 * @date 2020/12/4 11:15
 */
public class SummaryConsiderBomDetails extends DataEntity<SummaryConsiderBomDetails> {

    private Integer testing;                          //检测
    private Integer serialNumber;                     //序号
    private String blueIslandMaterielNumber;          //蓝岸料号
    private String supplierMaterielNumber;            //供应商料号编码
    private String description;                      //描述
    private String supplier;                         //供应商
    private Double dosageOfPlus;                     //plus 用量
    private Double dosageOfLite;                     //lite用量
    private Double supplierGoodProducts;             //厂商来料良品
    private Double supplierBadProducts;              //厂商来料不良
    private Double supplierReturnGoods;              //厂商退料
    private Double outWarehouse;                     //其他出库
    private Double delivery;                         //交货数量汇总
    private Double theoreticallyUsefully;            //理论可用数量汇总
    private Double actuallyUsefully;                 //可用套数
    private Double orderAmount;                      //下单数量
    private Double unpaidAmount;                     //订单未交
    private String replies;                          //交期回复

    @ExcelField(title = "检测",align = 2,sort = 1)
    public Integer getTesting() {
        return testing;
    }

    public void setTesting(Integer testing) {
        this.testing = testing;
    }

    @ExcelField(title = "序号",align = 2,sort = 2)
    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
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

    @ExcelField(title = "描述",align = 2,sort = 5)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ExcelField(title = "供应商",align = 2,sort = 6)
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @ExcelField(title = "plus用量",align = 2,sort = 7)
    public Double getDosageOfPlus() {
        return dosageOfPlus;
    }

    public void setDosageOfPlus(Double dosageOfPlus) {
        this.dosageOfPlus = dosageOfPlus;
    }

    @ExcelField(title = "lite用量",align = 2,sort = 8)
    public Double getDosageOfLite() {
        return dosageOfLite;
    }

    public void setDosageOfLite(Double dosageOfLite) {
        this.dosageOfLite = dosageOfLite;
    }

    @ExcelField(title = "厂商来料良品",align = 2,sort = 9)
    public Double getSupplierGoodProducts() {
        return supplierGoodProducts;
    }

    public void setSupplierGoodProducts(Double supplierGoodProducts) {
        this.supplierGoodProducts = supplierGoodProducts;
    }

    @ExcelField(title = "厂商来料不良",align = 2,sort = 10)
    public Double getSupplierBadProducts() {
        return supplierBadProducts;
    }

    public void setSupplierBadProducts(Double supplierBadProducts) {
        this.supplierBadProducts = supplierBadProducts;
    }

    @ExcelField(title = "厂商退料",align = 2,sort = 11)
    public Double getSupplierReturnGoods() {
        return supplierReturnGoods;
    }

    public void setSupplierReturnGoods(Double supplierReturnGoods) {
        this.supplierReturnGoods = supplierReturnGoods;
    }

    @ExcelField(title = "交货数量汇总",align = 2,sort = 12)
    public Double getOutWarehouse() {
        return outWarehouse;
    }

    public void setOutWarehouse(Double outWarehouse) {
        this.outWarehouse = outWarehouse;
    }

    @ExcelField(title = "理论可用数量汇总",align = 2,sort = 13)
    public Double getDelivery() {
        return delivery;
    }

    public void setDelivery(Double delivery) {
        this.delivery = delivery;
    }

    @ExcelField(title = "可用套数",align = 2,sort = 14)
    public Double getTheoreticallyUsefully() {
        return theoreticallyUsefully;
    }

    public void setTheoreticallyUsefully(Double theoreticallyUsefully) {
        this.theoreticallyUsefully = theoreticallyUsefully;
    }

    @ExcelField(title = "下单数量",align = 2,sort = 15)
    public Double getActuallyUsefully() {
        return actuallyUsefully;
    }

    public void setActuallyUsefully(Double actuallyUsefully) {
        this.actuallyUsefully = actuallyUsefully;
    }

    @ExcelField(title = "出库日期",align = 2,sort = 16)
    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @ExcelField(title = "订单未交",align = 2,sort = 17)
    public Double getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(Double unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    @ExcelField(title = "交期回复",align = 2,sort = 18)
    public String getReplies() {
        return replies;
    }

    public void setReplies(String replies) {
        this.replies = replies;
    }
}
