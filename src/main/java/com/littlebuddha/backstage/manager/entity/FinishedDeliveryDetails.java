package com.littlebuddha.backstage.manager.entity;

import com.littlebuddha.backstage.common.base.DataEntity;

import java.util.Date;

/**
 * 成品出库明细
 * @author ck
 * @date 2020/12/4 15:46
 */
public class FinishedDeliveryDetails extends DataEntity<FinishedDeliveryDetails> {

    private Date deliveryDate;                          //出库日期
    private String specification;                     //规格型号
    private String blueIslandFinishedProductCode;      //Blue bank finished product code
    private String productName;                        //产品名称
    private String orderNumberForJierong;             //给捷荣的加工订单号
    private String jierongDeliveryOrderNumber;         //捷容送货单号
    private Double shipmentAmount;                     //出货数量
    private String shipmentAddress;                     //出货地址
    private String receiver;                           //接货人

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getBlueIslandFinishedProductCode() {
        return blueIslandFinishedProductCode;
    }

    public void setBlueIslandFinishedProductCode(String blueIslandFinishedProductCode) {
        this.blueIslandFinishedProductCode = blueIslandFinishedProductCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderNumberForJierong() {
        return orderNumberForJierong;
    }

    public void setOrderNumberForJierong(String orderNumberForJierong) {
        this.orderNumberForJierong = orderNumberForJierong;
    }

    public String getJierongDeliveryOrderNumber() {
        return jierongDeliveryOrderNumber;
    }

    public void setJierongDeliveryOrderNumber(String jierongDeliveryOrderNumber) {
        this.jierongDeliveryOrderNumber = jierongDeliveryOrderNumber;
    }

    public Double getShipmentAmount() {
        return shipmentAmount;
    }

    public void setShipmentAmount(Double shipmentAmount) {
        this.shipmentAmount = shipmentAmount;
    }

    public String getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
