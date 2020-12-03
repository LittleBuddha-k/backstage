package com.littlebuddha.backstage.manager.entity;

import com.littlebuddha.backstage.common.base.DataEntity;

/**
 * @author ck
 * @date 2020/12/3 16:07
 */
public class BalanceDetails extends DataEntity<BalanceDetails> {

    private Integer serialNumber;                     //序号
    private Integer testing;                          //检测
    private Double texy;                             //TEXY
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

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getTesting() {
        return testing;
    }

    public void setTesting(Integer testing) {
        this.testing = testing;
    }

    public Double getTexy() {
        return texy;
    }

    public void setTexy(Double texy) {
        this.texy = texy;
    }

    public String getBlueIslandMaterielNumber() {
        return blueIslandMaterielNumber;
    }

    public void setBlueIslandMaterielNumber(String blueIslandMaterielNumber) {
        this.blueIslandMaterielNumber = blueIslandMaterielNumber;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Double getmFourHost() {
        return mFourHost;
    }

    public void setmFourHost(Double mFourHost) {
        this.mFourHost = mFourHost;
    }

    public Double getmFourGoHost() {
        return mFourGoHost;
    }

    public void setmFourGoHost(Double mFourGoHost) {
        this.mFourGoHost = mFourGoHost;
    }

    public Double getmFourFrontHousingAssembly() {
        return mFourFrontHousingAssembly;
    }

    public void setmFourFrontHousingAssembly(Double mFourFrontHousingAssembly) {
        this.mFourFrontHousingAssembly = mFourFrontHousingAssembly;
    }

    public Double getmFourRearHousingAssembly() {
        return mFourRearHousingAssembly;
    }

    public void setmFourRearHousingAssembly(Double mFourRearHousingAssembly) {
        this.mFourRearHousingAssembly = mFourRearHousingAssembly;
    }

    public Double getmFourPackage() {
        return mFourPackage;
    }

    public void setmFourPackage(Double mFourPackage) {
        this.mFourPackage = mFourPackage;
    }

    public Double getmFourOrange() {
        return mFourOrange;
    }

    public void setmFourOrange(Double mFourOrange) {
        this.mFourOrange = mFourOrange;
    }

    public Double getmFourSFR() {
        return mFourSFR;
    }

    public void setmFourSFR(Double mFourSFR) {
        this.mFourSFR = mFourSFR;
    }

    public Double getmFourBYT() {
        return mFourBYT;
    }

    public void setmFourBYT(Double mFourBYT) {
        this.mFourBYT = mFourBYT;
    }

    public Double getmFourGoPackage() {
        return mFourGoPackage;
    }

    public void setmFourGoPackage(Double mFourGoPackage) {
        this.mFourGoPackage = mFourGoPackage;
    }

    public Double getmFourFrontHousingAssemblySecond() {
        return mFourFrontHousingAssemblySecond;
    }

    public void setmFourFrontHousingAssemblySecond(Double mFourFrontHousingAssemblySecond) {
        this.mFourFrontHousingAssemblySecond = mFourFrontHousingAssemblySecond;
    }

    public Double getmFourMainBoardPackage() {
        return mFourMainBoardPackage;
    }

    public void setmFourMainBoardPackage(Double mFourMainBoardPackage) {
        this.mFourMainBoardPackage = mFourMainBoardPackage;
    }

    public Double getmFourGoMainBoardPackage() {
        return mFourGoMainBoardPackage;
    }

    public void setmFourGoMainBoardPackage(Double mFourGoMainBoardPackage) {
        this.mFourGoMainBoardPackage = mFourGoMainBoardPackage;
    }

    public Double getSmallBoardPackaging() {
        return smallBoardPackaging;
    }

    public void setSmallBoardPackaging(Double smallBoardPackaging) {
        this.smallBoardPackaging = smallBoardPackaging;
    }

    public Double getBatteryPackaging() {
        return batteryPackaging;
    }

    public void setBatteryPackaging(Double batteryPackaging) {
        this.batteryPackaging = batteryPackaging;
    }

    public Double getIntoOperation() {
        return intoOperation;
    }

    public void setIntoOperation(Double intoOperation) {
        this.intoOperation = intoOperation;
    }

    public Double getNotIntoOperation() {
        return notIntoOperation;
    }

    public void setNotIntoOperation(Double notIntoOperation) {
        this.notIntoOperation = notIntoOperation;
    }

    public Double getLackOfMaterial() {
        return lackOfMaterial;
    }

    public void setLackOfMaterial(Double lackOfMaterial) {
        this.lackOfMaterial = lackOfMaterial;
    }

    public Double getLackOfMaterialGroup() {
        return lackOfMaterialGroup;
    }

    public void setLackOfMaterialGroup(Double lackOfMaterialGroup) {
        this.lackOfMaterialGroup = lackOfMaterialGroup;
    }

    public Double getNewJersey() {
        return newJersey;
    }

    public void setNewJersey(Double newJersey) {
        this.newJersey = newJersey;
    }

    public Double getBlueIsland() {
        return blueIsland;
    }

    public void setBlueIsland(Double blueIsland) {
        this.blueIsland = blueIsland;
    }

    public Double getDifference() {
        return difference;
    }

    public void setDifference(Double difference) {
        this.difference = difference;
    }
}
