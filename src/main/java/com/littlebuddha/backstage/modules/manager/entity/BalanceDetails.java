package com.littlebuddha.backstage.modules.manager.entity;

import com.littlebuddha.backstage.common.anotations.ExcelField;
import com.littlebuddha.backstage.common.base.DataEntity;

/**
 * 赛达信组装盘点汇总表
 * @author ck
 * @date 2020/12/3 16:07
 */
public class BalanceDetails extends DataEntity<BalanceDetails> {

    private Integer serialNumber;                     //序号
    private Integer testing;                          //检测
    private String texy;                             //TEXY
    private String blueIslandMaterielNumber;                   //蓝岸料号
    private String chineseName;                      //中文名称
    private String supplier;                         //供应商
    private Double mFourHost;                        //M4主机
    private Double mFourGoHost;                      //M4 GO 主机
    private Double mFourFrontHousingAssembly;        //M4前壳组件
    private Double mFourRearHousingAssembly;         //M4后壳组件
    private Double mFourPackage;                     //M4包装
    private Double mFourOrange;                      //M4 Orange
    private Double mFourSFR;                         //M4-SFR
    private Double mFourBYT;                         //M4-BYT
    private Double mFourGoPackage;                   //M4 go包装
    private Double mFourFrontHousingAssemblySecond;                     //前壳组件
    private Double mFourMainBoardPackage;                     //主板包装
    private Double mFourGoMainBoardPackage;              //m4GO主板包装
    private Double smallBoardPackaging;                  //小板包装
    private Double batteryPackaging;                       //电池包装
    private Double intoOperation;                            //已投产
    private Double notIntoOperation;                         //未投产
    private Double lackOfMaterial;                               //欠料
    private Double lackOfMaterialGroup;                          //欠料（Group）
    private Double newJersey;                                     //新泽森
    private Double blueIsland;                                     //蓝岸
    private Double difference;                                     //差异

    @ExcelField(title = "序号",align = 2,sort = 1)
    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    @ExcelField(title = "检测",align = 2,sort = 2)
    public Integer getTesting() {
        return testing;
    }

    public void setTesting(Integer testing) {
        this.testing = testing;
    }

    @ExcelField(title = "TEXY",align = 2,sort = 3)
    public String getTexy() {
        return texy;
    }

    public void setTexy(String texy) {
        this.texy = texy;
    }

    @ExcelField(title = "蓝岸料号",align = 2,sort = 4)
    public String getBlueIslandMaterielNumber() {
        return blueIslandMaterielNumber;
    }

    public void setBlueIslandMaterielNumber(String blueIslandMaterielNumber) {
        this.blueIslandMaterielNumber = blueIslandMaterielNumber;
    }

    @ExcelField(title = "中文名称",align = 2,sort = 5)
    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    @ExcelField(title = "供应商",align = 2,sort = 6)
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @ExcelField(title = "M4主机",align = 2,sort = 7)
    public Double getmFourHost() {
        return mFourHost;
    }

    public void setmFourHost(Double mFourHost) {
        this.mFourHost = mFourHost;
    }

    @ExcelField(title = "M4GO主机",align = 2,sort = 8)
    public Double getmFourGoHost() {
        return mFourGoHost;
    }

    public void setmFourGoHost(Double mFourGoHost) {
        this.mFourGoHost = mFourGoHost;
    }

    @ExcelField(title = "M4前壳组件",align = 2,sort = 9)
    public Double getmFourFrontHousingAssembly() {
        return mFourFrontHousingAssembly;
    }

    public void setmFourFrontHousingAssembly(Double mFourFrontHousingAssembly) {
        this.mFourFrontHousingAssembly = mFourFrontHousingAssembly;
    }

    @ExcelField(title = "M4后壳组件",align = 2,sort = 10)
    public Double getmFourRearHousingAssembly() {
        return mFourRearHousingAssembly;
    }

    public void setmFourRearHousingAssembly(Double mFourRearHousingAssembly) {
        this.mFourRearHousingAssembly = mFourRearHousingAssembly;
    }

    @ExcelField(title = "M4包装",align = 2,sort = 11)
    public Double getmFourPackage() {
        return mFourPackage;
    }

    public void setmFourPackage(Double mFourPackage) {
        this.mFourPackage = mFourPackage;
    }

    @ExcelField(title = "M4Orange",align = 2,sort = 12)
    public Double getmFourOrange() {
        return mFourOrange;
    }

    public void setmFourOrange(Double mFourOrange) {
        this.mFourOrange = mFourOrange;
    }

    @ExcelField(title = "M4-SFR",align = 2,sort = 13)
    public Double getmFourSFR() {
        return mFourSFR;
    }

    public void setmFourSFR(Double mFourSFR) {
        this.mFourSFR = mFourSFR;
    }

    @ExcelField(title = "M4-BYT",align = 2,sort = 14)
    public Double getmFourBYT() {
        return mFourBYT;
    }

    public void setmFourBYT(Double mFourBYT) {
        this.mFourBYT = mFourBYT;
    }

    @ExcelField(title = "M4go包装",align = 2,sort = 15)
    public Double getmFourGoPackage() {
        return mFourGoPackage;
    }

    public void setmFourGoPackage(Double mFourGoPackage) {
        this.mFourGoPackage = mFourGoPackage;
    }

    @ExcelField(title = "前壳组件",align = 2,sort = 16)
    public Double getmFourFrontHousingAssemblySecond() {
        return mFourFrontHousingAssemblySecond;
    }

    public void setmFourFrontHousingAssemblySecond(Double mFourFrontHousingAssemblySecond) {
        this.mFourFrontHousingAssemblySecond = mFourFrontHousingAssemblySecond;
    }

    @ExcelField(title = "主板包装",align = 2,sort = 17)
    public Double getmFourMainBoardPackage() {
        return mFourMainBoardPackage;
    }

    public void setmFourMainBoardPackage(Double mFourMainBoardPackage) {
        this.mFourMainBoardPackage = mFourMainBoardPackage;
    }

    @ExcelField(title = "m4GO主板包装",align = 2,sort = 18)
    public Double getmFourGoMainBoardPackage() {
        return mFourGoMainBoardPackage;
    }

    public void setmFourGoMainBoardPackage(Double mFourGoMainBoardPackage) {
        this.mFourGoMainBoardPackage = mFourGoMainBoardPackage;
    }

    @ExcelField(title = "小板包装",align = 2,sort = 19)
    public Double getSmallBoardPackaging() {
        return smallBoardPackaging;
    }

    public void setSmallBoardPackaging(Double smallBoardPackaging) {
        this.smallBoardPackaging = smallBoardPackaging;
    }

    @ExcelField(title = "电池包装",align = 2,sort = 20)
    public Double getBatteryPackaging() {
        return batteryPackaging;
    }

    public void setBatteryPackaging(Double batteryPackaging) {
        this.batteryPackaging = batteryPackaging;
    }

    @ExcelField(title = "已投产",align = 2,sort = 21)
    public Double getIntoOperation() {
        return intoOperation;
    }

    public void setIntoOperation(Double intoOperation) {
        this.intoOperation = intoOperation;
    }

    @ExcelField(title = "未投产",align = 2,sort = 22)
    public Double getNotIntoOperation() {
        return notIntoOperation;
    }

    public void setNotIntoOperation(Double notIntoOperation) {
        this.notIntoOperation = notIntoOperation;
    }

    @ExcelField(title = "欠料",align = 2,sort = 23)
    public Double getLackOfMaterial() {
        return lackOfMaterial;
    }

    public void setLackOfMaterial(Double lackOfMaterial) {
        this.lackOfMaterial = lackOfMaterial;
    }

    @ExcelField(title = "欠料（Group）",align = 2,sort = 24)
    public Double getLackOfMaterialGroup() {
        return lackOfMaterialGroup;
    }

    public void setLackOfMaterialGroup(Double lackOfMaterialGroup) {
        this.lackOfMaterialGroup = lackOfMaterialGroup;
    }

    @ExcelField(title = "新泽森",align = 2,sort = 25)
    public Double getNewJersey() {
        return newJersey;
    }

    public void setNewJersey(Double newJersey) {
        this.newJersey = newJersey;
    }

    @ExcelField(title = "蓝岸",align = 2,sort = 26)
    public Double getBlueIsland() {
        return blueIsland;
    }

    public void setBlueIsland(Double blueIsland) {
        this.blueIsland = blueIsland;
    }

    @ExcelField(title = "差异",align = 2,sort = 27)
    public Double getDifference() {
        return difference;
    }

    public void setDifference(Double difference) {
        this.difference = difference;
    }
}
