package com.xhx.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort01 {

    public static double[] bucketSort(double[] array){
        //1 取得数列最大值、最小值与差值d
        double max = array[0];
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max = array[i];
            }
            if(array[i]<min){
                min = array[i];
            }
        }
        double d = max - min;

        //2 初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }

        for (int i = 0; i < array.length; i++) {
            int num = (int)((array[i] - min) * (bucketNum - 1)/d);
            bucketList.get(num).add(array[i]);
        }
        //对每个桶内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        //输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList){
            for(double element : list){
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

}
