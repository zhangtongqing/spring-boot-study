package com.minbo.springdemo.web.luckDraw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 不同概率抽奖工具包
 * Created by Administrator on 2018/5/3.
 */
public class LotteryUtil {

    /**
     * @param orignalRates 原始概率列表
     * @return
     */
    public static int lottery(List<Double> orignalRates){

        if(null == orignalRates || orignalRates.isEmpty()){
            return  -1;
        }

        int size = orignalRates.size();

        //计算总概率 这样可以保证总概率 不一定是1
        double sumRate = 0d;
        for(double rate: orignalRates){
            sumRate += rate;
        }

        //计算每个物品在总概率的基础下，的概率情况
        List<Double> sortOrignalRates = new ArrayList<Double>(size);
        Double  tempSumRate = 0d;
        for(double rate : orignalRates){
            tempSumRate += rate;
            sortOrignalRates.add(tempSumRate / sumRate);
        }

        //根据区块值来获取到物品索引
        double nextDouble = Math.random();
        sortOrignalRates.add(nextDouble);
        Collections.sort(sortOrignalRates);
        return sortOrignalRates.indexOf(nextDouble);
    }

}
