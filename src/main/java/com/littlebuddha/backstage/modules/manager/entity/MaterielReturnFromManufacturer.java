package com.littlebuddha.backstage.modules.manager.entity;

import com.littlebuddha.backstage.common.anotations.ExcelField;
import com.littlebuddha.backstage.common.base.DataEntity;

import java.util.Date;

/**
 * 厂商退料
 * @author ck
 * @date 2020/12/4 15:46
 */
public class MaterielReturnFromManufacturer extends DataEntity<MaterielReturnFromManufacturer> {

    private Integer serialNumber;                     //序号
    private Date returnDate;                          //退货日期
    private String blueIslandMaterielNumber;          //蓝岸料号
    private String returnManufacturer;                //退货厂商
    private String supplierMaterielNumber;            //供应商料号编码
    private String materielName;                      //物料名称
    private String description;                       //描述
    private Double returnAmount;                     //退货数量
    private String returnOrderNumber;                 //退货单号

    @ExcelField(title = "序号",align = 2,sort = 1)
    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    @ExcelField(title = "退货日期",align = 2,sort = 2)
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @ExcelField(title = "蓝岸料号",align = 2,sort = 3)
    public String getBlueIslandMaterielNumber() {
        return blueIslandMaterielNumber;
    }

    public void setBlueIslandMaterielNumber(String blueIslandMaterielNumber) {
        this.blueIslandMaterielNumber = blueIslandMaterielNumber;
    }

    @ExcelField(title = "退货厂商",align = 2,sort = 4)
    public String getReturnManufacturer() {
        return returnManufacturer;
    }

    public void setReturnManufacturer(String returnManufacturer) {
        this.returnManufacturer = returnManufacturer;
    }

    @ExcelField(title = "供应商料号编码",align = 2,sort = 5)
    public String getSupplierMaterielNumber() {
        return supplierMaterielNumber;
    }

    public void setSupplierMaterielNumber(String supplierMaterielNumber) {
        this.supplierMaterielNumber = supplierMaterielNumber;
    }

    @ExcelField(title = "物料名称",align = 2,sort = 6)
    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    @ExcelField(title = "描述",align = 2,sort = 7)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ExcelField(title = "退货数量",align = 2,sort = 8)
    public Double getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(Double returnAmount) {
        this.returnAmount = returnAmount;
    }

    @ExcelField(title = "退货单号",align = 2,sort = 9)
    public String getReturnOrderNumber() {
        return returnOrderNumber;
    }

    public void setReturnOrderNumber(String returnOrderNumber) {
        this.returnOrderNumber = returnOrderNumber;
    }
}
