package com.littlebuddha.backstage.manager.entity;

import com.littlebuddha.backstage.common.base.DataEntity;

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

    public Integer getTesting() {
        return testing;
    }

    public void setTesting(Integer testing) {
        this.testing = testing;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Double getDosageOfPlus() {
        return dosageOfPlus;
    }

    public void setDosageOfPlus(Double dosageOfPlus) {
        this.dosageOfPlus = dosageOfPlus;
    }

    public Double getDosageOfLite() {
        return dosageOfLite;
    }

    public void setDosageOfLite(Double dosageOfLite) {
        this.dosageOfLite = dosageOfLite;
    }

    public Double getSupplierGoodProducts() {
        return supplierGoodProducts;
    }

    public void setSupplierGoodProducts(Double supplierGoodProducts) {
        this.supplierGoodProducts = supplierGoodProducts;
    }

    public Double getSupplierBadProducts() {
        return supplierBadProducts;
    }

    public void setSupplierBadProducts(Double supplierBadProducts) {
        this.supplierBadProducts = supplierBadProducts;
    }

    public Double getSupplierReturnGoods() {
        return supplierReturnGoods;
    }

    public void setSupplierReturnGoods(Double supplierReturnGoods) {
        this.supplierReturnGoods = supplierReturnGoods;
    }

    public Double getOutWarehouse() {
        return outWarehouse;
    }

    public void setOutWarehouse(Double outWarehouse) {
        this.outWarehouse = outWarehouse;
    }

    public Double getDelivery() {
        return delivery;
    }

    public void setDelivery(Double delivery) {
        this.delivery = delivery;
    }

    public Double getTheoreticallyUsefully() {
        return theoreticallyUsefully;
    }

    public void setTheoreticallyUsefully(Double theoreticallyUsefully) {
        this.theoreticallyUsefully = theoreticallyUsefully;
    }

    public Double getActuallyUsefully() {
        return actuallyUsefully;
    }

    public void setActuallyUsefully(Double actuallyUsefully) {
        this.actuallyUsefully = actuallyUsefully;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(Double unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    public String getReplies() {
        return replies;
    }

    public void setReplies(String replies) {
        this.replies = replies;
    }
}
