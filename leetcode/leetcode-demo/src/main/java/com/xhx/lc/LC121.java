package com.xhx.lc;

public class LC121 {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(new LC121().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0], max = prices[0];
        int range = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > min){
                if(max < prices[i] ){
                    max = prices[i];
                }
            }else if(prices[i] < min){
                int tem = max - min;
                if(range < tem){
                    range = tem;
                }

                max = min = prices[i];
            }
        }
        int tem = max - min;
        if(range < tem){
            range = tem;
        }
        return range;

    }

}
