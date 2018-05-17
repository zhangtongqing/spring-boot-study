package com.minbo.springdemo.web.luckDraw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/3.
 */
public class LotteryTest {
    public static void main(String[] args){
        List<Gift>  gifts = new ArrayList<Gift>();

        // 序号-物品Id-物品名称-概率
        gifts.add(new Gift(1,"P1","物品1",0.2d));
        gifts.add(new Gift(2,"P2","物品2",0.2d));
        gifts.add(new Gift(3,"P3","物品3",0.4d));
        gifts.add(new Gift(4,"P4","物品4",0.3d));
        gifts.add(new Gift(5,"P5","物品5",0.5d));
        gifts.add(new Gift(6,"P6","物品6",0d));

        //概率规则列表
        List<Double> orignaRates = new ArrayList<Double>(gifts.size());
        for(Gift gift : gifts){
            double probability = gift.getProbability();
            if(probability < 0){
                probability = 0;
            }
            orignaRates.add(probability);
        }

        //抽奖前先，构造物品的概率列表
        Map<Integer,Integer> count = new HashMap<Integer,Integer>();
        double num = 100;
        for(int i=0; i< num; i++){
            int orignaIndex = LotteryUtil.lottery(orignaRates);
            Integer value = count.get(orignaIndex);
            count.put(orignaIndex, value == null ? 1 : value + 1);
        }

        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
          System.out.println( gifts.get(entry.getKey()) + " ,count ="+ entry.getValue() +" probability = " + entry.getValue() / num);
        }
    }
}
