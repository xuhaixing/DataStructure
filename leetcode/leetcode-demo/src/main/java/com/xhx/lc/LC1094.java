package com.xhx.lc;

/**
 * @description:
 * @author: xuhaixing
 * @Date: 2021/12/14 11:20 下午
 */
public class LC1094 {

    class Solution {
        int[] diff = null;

        public boolean carPooling(int[][] trips, int capacity) {

            diff = new int[1001];
            for (int[] trip : trips) {
                //乘客在车上的区间是[trip[1], trip[2] - 1]
                calc(trip[1], trip[2] - 1, trip[0]);
            }
            if(diff[0] > capacity){
                return false;
            }
            for (int i = 1; i < diff.length; i++) {
                diff[i] += diff[i - 1];
                if (diff[i] > capacity) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 差分数组经典代码块
         * @param i
         * @param j
         * @param val
         */
        public void calc(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }
    }

}
