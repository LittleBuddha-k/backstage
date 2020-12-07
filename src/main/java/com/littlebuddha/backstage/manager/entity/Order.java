package com.littlebuddha.backstage.manager.entity;

import com.littlebuddha.backstage.common.base.DataEntity;
import com.littlebuddha.backstage.system.entity.Operator;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 订单录入
 * @author ck
 * @date 2020/12/2 10:49
 */
public class Order extends DataEntity {

    private String newOrderNumber;          //新订单号
    private String orderNumber;             //订单编号
    private String supplier;                //供应商
    private String projectName;             //项目名
    private String materielNumber;          //蓝岸料号
    private String materielNumberSort;      //蓝岸料号格式
    private String materielName;            //物料名称
    private String specifications;          //规格
    private String description ;            //描述
    private String brand;                   //品牌
    private String unit;                    //单位
    private Double orderAmount;             //下单数量
    private Double unitPrice;               //单价
    private String currency;                //币种
    private Double totalAmount;             //总金额

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderDate;                 //下单日期

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deliveryDate;              //交期

    private Double deliveredAmount;         //已交货数量

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inWarehousingDate;         //入库日期

    private Double undeliveredAmount;       //未交货数量
    private String firstPartyRemarks;       //备注

    private Double reconciledAmount;        //已对帐数量
    private Double noReconciliation;        //未对帐数量
    private String paymentStatus;           //付款情况
    private String paymentWay;              //付款方式
    private Operator theCorrespondingHuman; //对应人
    private String secondPartyRemarks;      //备注

    public String getNewOrderNumber() {
        return newOrderNumber;
    }

    public void setNewOrderNumber(String newOrderNumber) {
        this.newOrderNumber = newOrderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMaterielNumber() {
        return materielNumber;
    }

    public void setMaterielNumber(String materielNumber) {
        this.materielNumber = materielNumber;
    }

    public String getMaterielNumberSort() {
        return materielNumberSort;
    }

    public void setMaterielNumberSort(String materielNumberSort) {
        this.materielNumberSort = materielNumberSort;
    }

    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getDeliveredAmount() {
        return deliveredAmount;
    }

    public void setDeliveredAmount(Double deliveredAmount) {
        this.deliveredAmount = deliveredAmount;
    }

    public Date getInWarehousingDate() {
        return inWarehousingDate;
    }

    public void setInWarehousingDate(Date inWarehousingDate) {
        this.inWarehousingDate = inWarehousingDate;
    }

    public Double getUndeliveredAmount() {
        return undeliveredAmount;
    }

    public void setUndeliveredAmount(Double undeliveredAmount) {
        this.undeliveredAmount = undeliveredAmount;
    }

    public String getFirstPartyRemarks() {
        return firstPartyRemarks;
    }

    public void setFirstPartyRemarks(String firstPartyRemarks) {
        this.firstPartyRemarks = firstPartyRemarks;
    }

    public Double getReconciledAmount() {
        return reconciledAmount;
    }

    public void setReconciledAmount(Double reconciledAmount) {
        this.reconciledAmount = reconciledAmount;
    }

    public Double getNoReconciliation() {
        return noReconciliation;
    }

    public void setNoReconciliation(Double noReconciliation) {
        this.noReconciliation = noReconciliation;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public Operator getTheCorrespondingHuman() {
        return theCorrespondingHuman;
    }

    public void setTheCorrespondingHuman(Operator theCorrespondingHuman) {
        this.theCorrespondingHuman = theCorrespondingHuman;
    }

    public String getSecondPartyRemarks() {
        return secondPartyRemarks;
    }

    public void setSecondPartyRemarks(String secondPartyRemarks) {
        this.secondPartyRemarks = secondPartyRemarks;
    }
}
