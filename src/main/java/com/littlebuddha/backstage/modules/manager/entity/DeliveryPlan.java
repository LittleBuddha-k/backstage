package com.littlebuddha.backstage.modules.manager.entity;

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

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(Double deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    public Double getCumulativeDeliveryAmount() {
        return cumulativeDeliveryAmount;
    }

    public void setCumulativeDeliveryAmount(Double cumulativeDeliveryAmount) {
        this.cumulativeDeliveryAmount = cumulativeDeliveryAmount;
    }

    public Date getInComingMaterielDate() {
        return inComingMaterielDate;
    }

    public void setInComingMaterielDate(Date inComingMaterielDate) {
        this.inComingMaterielDate = inComingMaterielDate;
    }

    public Double getGiftBoxAmount() {
        return giftBoxAmount;
    }

    public void setGiftBoxAmount(Double giftBoxAmount) {
        this.giftBoxAmount = giftBoxAmount;
    }

    public Double getCumulativeGiftBoxAmount() {
        return cumulativeGiftBoxAmount;
    }

    public void setCumulativeGiftBoxAmount(Double cumulativeGiftBoxAmount) {
        this.cumulativeGiftBoxAmount = cumulativeGiftBoxAmount;
    }

    public Double getCartonAmount() {
        return cartonAmount;
    }

    public void setCartonAmount(Double cartonAmount) {
        this.cartonAmount = cartonAmount;
    }

    public Double getPaperSeparatorAmount() {
        return paperSeparatorAmount;
    }

    public void setPaperSeparatorAmount(Double paperSeparatorAmount) {
        this.paperSeparatorAmount = paperSeparatorAmount;
    }

    public Double getCumulativePaperSeparatorAmount() {
        return cumulativePaperSeparatorAmount;
    }

    public void setCumulativePaperSeparatorAmount(Double cumulativePaperSeparatorAmount) {
        this.cumulativePaperSeparatorAmount = cumulativePaperSeparatorAmount;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
