package com.littlebuddha.backstage.modules.manager.entity;

import com.littlebuddha.backstage.common.anotations.ExcelField;
import com.littlebuddha.backstage.modules.base.DataEntity;

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

    @ExcelField(title = "出库日期",align = 2,sort = 1)
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @ExcelField(title = "规格型号",align = 2,sort = 2)
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @ExcelField(title = "蓝岸成品编码",align = 2,sort = 3)
    public String getBlueIslandFinishedProductCode() {
        return blueIslandFinishedProductCode;
    }

    public void setBlueIslandFinishedProductCode(String blueIslandFinishedProductCode) {
        this.blueIslandFinishedProductCode = blueIslandFinishedProductCode;
    }

    @ExcelField(title = "产品名",align = 2,sort = 4)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @ExcelField(title = "捷荣订单号",align = 2,sort = 5)
    public String getOrderNumberForJierong() {
        return orderNumberForJierong;
    }

    public void setOrderNumberForJierong(String orderNumberForJierong) {
        this.orderNumberForJierong = orderNumberForJierong;
    }

    @ExcelField(title = "捷荣加工订单号",align = 2,sort = 6)
    public String getJierongDeliveryOrderNumber() {
        return jierongDeliveryOrderNumber;
    }

    public void setJierongDeliveryOrderNumber(String jierongDeliveryOrderNumber) {
        this.jierongDeliveryOrderNumber = jierongDeliveryOrderNumber;
    }

    @ExcelField(title = "出货数量",align = 2,sort = 7)
    public Double getShipmentAmount() {
        return shipmentAmount;
    }

    public void setShipmentAmount(Double shipmentAmount) {
        this.shipmentAmount = shipmentAmount;
    }

    @ExcelField(title = "出货地址",align = 2,sort = 8)
    public String getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    @ExcelField(title = "接货人",align = 2,sort = 9)
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
