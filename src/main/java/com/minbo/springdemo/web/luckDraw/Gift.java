package com.minbo.springdemo.web.luckDraw;

/**
 * Created by Administrator on 2018/5/3.
 * 奖品类
 */
public class Gift {
    private  int index;
    private String giftId;    //礼品Id
    private String giftName;   //礼品名字
    private double probability; //概率


    public Gift(int index, String giftId, String giftName, double probability) {
        this.index = index;
        this.giftId = giftId;
        this.giftName = giftName;
        this.probability = probability;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "index=" + index +
                ", giftId='" + giftId + '\'' +
                ", giftName='" + giftName + '\'' +
                ", probability=" + probability +
                '}';
    }
}
