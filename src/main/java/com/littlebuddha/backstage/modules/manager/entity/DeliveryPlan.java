package com.littlebuddha.backstage.modules.manager.entity;

import com.littlebuddha.backstage.common.anotations.ExcelField;
import com.littlebuddha.backstage.common.base.DataEntity;

import java.util.Date;

/**
 * 交货计划，包含lite和plus
 * @author ck
 * @date 2020/12/7 10:41
 */
public class DeliveryPlan extends DataEntity<DeliveryPlan> {

    private Date deliveryDate;                        //交货日期
    private Double deliveryAmount;                    //交货数量
    private Double cumulativeDeliveryAmount;          //累计交货数量
    private Date inComingMaterielDate;                //进料日期

    private Double giftBoxAmount;             //礼盒配套lite数量
    private Double cumulativeGiftBoxAmount;   //累计lite礼盒数量
    private Double cartonAmount;                  //lite纸箱数
    private Double paperSeparatorAmount;          //lite纸隔板数
    private Double cumulativePaperSeparatorAmount;//累计lite纸隔板数

    private String deliveryType;                      //交货计划类型---lite or plus

    @ExcelField(title = "交货日期",align = 2,sort = 1)
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @ExcelField(title = "交货数量",align = 2,sort = 2)
    public Double getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(Double deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    @ExcelField(title = "累计交货数量",align = 2,sort = 3)
    public Double getCumulativeDeliveryAmount() {
        return cumulativeDeliveryAmount;
    }

    public void setCumulativeDeliveryAmount(Double cumulativeDeliveryAmount) {
        this.cumulativeDeliveryAmount = cumulativeDeliveryAmount;
    }

    @ExcelField(title = "进货日期",align = 2,sort = 4)
    public Date getInComingMaterielDate() {
        return inComingMaterielDate;
    }

    public void setInComingMaterielDate(Date inComingMaterielDate) {
        this.inComingMaterielDate = inComingMaterielDate;
    }

    @ExcelField(title = "礼盒数量",align = 2,sort = 5)
    public Double getGiftBoxAmount() {
        return giftBoxAmount;
    }

    public void setGiftBoxAmount(Double giftBoxAmount) {
        this.giftBoxAmount = giftBoxAmount;
    }

    @ExcelField(title = "累计礼盒数量",align = 2,sort = 6)
    public Double getCumulativeGiftBoxAmount() {
        return cumulativeGiftBoxAmount;
    }

    public void setCumulativeGiftBoxAmount(Double cumulativeGiftBoxAmount) {
        this.cumulativeGiftBoxAmount = cumulativeGiftBoxAmount;
    }

    @ExcelField(title = "彩盒数量",align = 2,sort = 7)
    public Double getCartonAmount() {
        return cartonAmount;
    }

    public void setCartonAmount(Double cartonAmount) {
        this.cartonAmount = cartonAmount;
    }

    @ExcelField(title = "纸格板数量",align = 2,sort = 8)
    public Double getPaperSeparatorAmount() {
        return paperSeparatorAmount;
    }

    public void setPaperSeparatorAmount(Double paperSeparatorAmount) {
        this.paperSeparatorAmount = paperSeparatorAmount;
    }

    @ExcelField(title = "累计纸格板数量",align = 2,sort = 9)
    public Double getCumulativePaperSeparatorAmount() {
        return cumulativePaperSeparatorAmount;
    }

    public void setCumulativePaperSeparatorAmount(Double cumulativePaperSeparatorAmount) {
        this.cumulativePaperSeparatorAmount = cumulativePaperSeparatorAmount;
    }

    @ExcelField(title = "交货类型",align = 2,sort = 10)
    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
