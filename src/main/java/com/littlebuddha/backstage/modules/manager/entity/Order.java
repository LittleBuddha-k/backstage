package com.littlebuddha.backstage.modules.manager.entity;

import com.littlebuddha.backstage.common.anotations.ExcelField;
import com.littlebuddha.backstage.common.base.DataEntity;
import com.littlebuddha.backstage.modules.system.entity.Operator;
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

    @ExcelField(title = "新订单号",align = 2,sort = 1)
    public String getNewOrderNumber() {
        return newOrderNumber;
    }

    public void setNewOrderNumber(String newOrderNumber) {
        this.newOrderNumber = newOrderNumber;
    }

    @ExcelField(title = "订单编号",align = 2,sort = 2)
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @ExcelField(title = "供应商",align = 2,sort = 3)
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @ExcelField(title = "项目名",align = 2,sort = 4)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @ExcelField(title = "蓝岸料号",align = 2,sort = 5)
    public String getMaterielNumber() {
        return materielNumber;
    }

    public void setMaterielNumber(String materielNumber) {
        this.materielNumber = materielNumber;
    }

    @ExcelField(title = "蓝岸料号格式",align = 2,sort = 6)
    public String getMaterielNumberSort() {
        return materielNumberSort;
    }

    public void setMaterielNumberSort(String materielNumberSort) {
        this.materielNumberSort = materielNumberSort;
    }

    @ExcelField(title = "物料名称",align = 2,sort = 7)
    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    @ExcelField(title = "规格",align = 2,sort = 8)
    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    @ExcelField(title = "描述",align = 2,sort = 9)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ExcelField(title = "品牌",align = 2,sort = 10)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @ExcelField(title = "单位",align = 2,sort = 11)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @ExcelField(title = "下单数量",align = 2,sort = 12)
    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @ExcelField(title = "单价",align = 2,sort = 13)
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @ExcelField(title = "币种",align = 2,sort = 14)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @ExcelField(title = "总金额",align = 2,sort = 15)
    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @ExcelField(title = "下单日期",align = 2,sort = 16)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @ExcelField(title = "交期",align = 2,sort = 17)
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @ExcelField(title = "已交货数量",align = 2,sort = 18)
    public Double getDeliveredAmount() {
        return deliveredAmount;
    }

    public void setDeliveredAmount(Double deliveredAmount) {
        this.deliveredAmount = deliveredAmount;
    }

    @ExcelField(title = "入库日期",align = 2,sort = 19)
    public Date getInWarehousingDate() {
        return inWarehousingDate;
    }

    public void setInWarehousingDate(Date inWarehousingDate) {
        this.inWarehousingDate = inWarehousingDate;
    }

    @ExcelField(title = "未交货数量",align = 2,sort = 20)
    public Double getUndeliveredAmount() {
        return undeliveredAmount;
    }

    public void setUndeliveredAmount(Double undeliveredAmount) {
        this.undeliveredAmount = undeliveredAmount;
    }

    @ExcelField(title = "备注",align = 2,sort = 21)
    public String getFirstPartyRemarks() {
        return firstPartyRemarks;
    }

    public void setFirstPartyRemarks(String firstPartyRemarks) {
        this.firstPartyRemarks = firstPartyRemarks;
    }

    @ExcelField(title = "已对帐数量",align = 2,sort = 22)
    public Double getReconciledAmount() {
        return reconciledAmount;
    }

    public void setReconciledAmount(Double reconciledAmount) {
        this.reconciledAmount = reconciledAmount;
    }

    @ExcelField(title = "未对帐数量",align = 2,sort = 23)
    public Double getNoReconciliation() {
        return noReconciliation;
    }

    public void setNoReconciliation(Double noReconciliation) {
        this.noReconciliation = noReconciliation;
    }

    @ExcelField(title = "付款情况",align = 2,sort = 24)
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @ExcelField(title = "付款方式",align = 2,sort = 25)
    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    @ExcelField(title = "对应人",align = 2,sort = 26)
    public Operator getTheCorrespondingHuman() {
        return theCorrespondingHuman;
    }

    public void setTheCorrespondingHuman(Operator theCorrespondingHuman) {
        this.theCorrespondingHuman = theCorrespondingHuman;
    }

    @ExcelField(title = "备注",align = 2,sort = 27)
    public String getSecondPartyRemarks() {
        return secondPartyRemarks;
    }

    public void setSecondPartyRemarks(String secondPartyRemarks) {
        this.secondPartyRemarks = secondPartyRemarks;
    }
}
