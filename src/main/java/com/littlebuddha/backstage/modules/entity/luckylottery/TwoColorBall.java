package com.littlebuddha.backstage.modules.entity.luckylottery;

import com.littlebuddha.backstage.common.anotations.ExcelField;
import com.littlebuddha.backstage.modules.base.DataEntity;

import java.util.Date;
import java.util.List;

/**
 * @author ck
 * @date 2021/1/13 10:05
 */
public class TwoColorBall extends DataEntity<TwoColorBall> {

    private String issueNumber;                         //期號
    private List<Integer> redBall;                      //紅球
    private String redOne;                             //一號紅球
    private String redTwo;                             //二號紅球
    private String redThree;                           //三號紅球
    private String redFour;                            //四號紅球
    private String redFive;                            //五號紅球
    private String redSix;                             //六號紅球
    private String blueBall;                           //藍球
    private String happySunday;                           //歡樂星期天
    private String bonusPool;                           //獎池獎金
    private String firstPrize;                          //一等奖
    private String firstPrizeWinningCount;                        //中奖数
    private String firstPrizeBonus;                               //奖金
    private String secondPrize;                          //二等奖
    private String secondPrizeWinningCount;                        //中奖数
    private String secondPrizeBonus;                               //奖金
    private String totalBetsMoney;                      //縂投注額
    private Date drawDate;                              //開獎日期

    @ExcelField(title = "期號",align = 2,sort = 1)
    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public List<Integer> getRedBall() {
        return redBall;
    }

    public void setRedBall(List<Integer> redBall) {
        this.redBall = redBall;
    }

    @ExcelField(title = "一號紅球",align = 2,sort = 2)
    public String getRedOne() {
        return redOne;
    }

    public void setRedOne(String redOne) {
        this.redOne = redOne;
    }

    @ExcelField(title = "二號紅球",align = 2,sort = 3)
    public String getRedTwo() {
        return redTwo;
    }

    public void setRedTwo(String redTwo) {
        this.redTwo = redTwo;
    }

    @ExcelField(title = "三號紅球",align = 2,sort = 4)
    public String getRedThree() {
        return redThree;
    }

    public void setRedThree(String redThree) {
        this.redThree = redThree;
    }

    @ExcelField(title = "四號紅球",align = 2,sort = 5)
    public String getRedFour() {
        return redFour;
    }

    public void setRedFour(String redFour) {
        this.redFour = redFour;
    }

    @ExcelField(title = "五號紅球",align = 2,sort = 6)
    public String getRedFive() {
        return redFive;
    }

    public void setRedFive(String redFive) {
        this.redFive = redFive;
    }

    @ExcelField(title = "六號紅球",align = 2,sort = 7)
    public String getRedSix() {
        return redSix;
    }

    public void setRedSix(String redSix) {
        this.redSix = redSix;
    }

    @ExcelField(title = "藍球",align = 2,sort = 8)
    public String getBlueBall() {
        return blueBall;
    }

    public void setBlueBall(String blueBall) {
        this.blueBall = blueBall;
    }

    @ExcelField(title = "歡樂星期天",align = 2,sort = 9)
    public String getHappySunday() {
        return happySunday;
    }

    public void setHappySunday(String happySunday) {
        this.happySunday = happySunday;
    }

    @ExcelField(title = "獎池獎金",align = 2,sort = 10)
    public String getBonusPool() {
        return bonusPool;
    }

    public void setBonusPool(String bonusPool) {
        this.bonusPool = bonusPool;
    }

    public String getFirstPrize() {
        return firstPrize;
    }

    public void setFirstPrize(String firstPrize) {
        this.firstPrize = firstPrize;
    }

    @ExcelField(title = "一等奖中奖数",align = 2,sort = 11)
    public String getFirstPrizeWinningCount() {
        return firstPrizeWinningCount;
    }

    public void setFirstPrizeWinningCount(String firstPrizeWinningCount) {
        this.firstPrizeWinningCount = firstPrizeWinningCount;
    }

    @ExcelField(title = "一等奖奖金",align = 2,sort = 12)
    public String getFirstPrizeBonus() {
        return firstPrizeBonus;
    }

    public void setFirstPrizeBonus(String firstPrizeBonus) {
        this.firstPrizeBonus = firstPrizeBonus;
    }

    public String getSecondPrize() {
        return secondPrize;
    }

    public void setSecondPrize(String secondPrize) {
        this.secondPrize = secondPrize;
    }

    @ExcelField(title = "二等奖中奖数",align = 2,sort = 13)
    public String getSecondPrizeWinningCount() {
        return secondPrizeWinningCount;
    }

    public void setSecondPrizeWinningCount(String secondPrizeWinningCount) {
        this.secondPrizeWinningCount = secondPrizeWinningCount;
    }

    @ExcelField(title = "二等奖奖金",align = 2,sort = 14)
    public String getSecondPrizeBonus() {
        return secondPrizeBonus;
    }

    public void setSecondPrizeBonus(String secondPrizeBonus) {
        this.secondPrizeBonus = secondPrizeBonus;
    }

    @ExcelField(title = "縂投注額",align = 2,sort = 15)
    public String getTotalBetsMoney() {
        return totalBetsMoney;
    }

    public void setTotalBetsMoney(String totalBetsMoney) {
        this.totalBetsMoney = totalBetsMoney;
    }

    @ExcelField(title = "開獎日期",align = 2,sort = 16)
    public Date getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }
}
