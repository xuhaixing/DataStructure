package com.xhx.lc;

/**
 * @description:
 * @author: xuhaixing
 * @Date: 2021/12/14 10:44 下午
 */
public class LC1109 {

    /**
     * 因为题⽬说的 n 是从 1 开始计数的，⽽数组索引从 0 开始，所以对于输⼊的三元组 (i,j,k)，
     * 数组区间应该对应 [i-1,j-1]。
     */
    class Solution {
        public int[] corpFlightBookings(int[][] updates, int length) {
            int[] diff = new int[length];

            for (int i = 0; i < updates.length; i++) {
                diff[updates[i][0]-1] += updates[i][2];
                if (updates[i][1] < length) {
                    diff[updates[i][1]] -= updates[i][2];
                }
            }
            for (int i = 1; i < diff.length; i++) {
                diff[i] = diff[i - 1] + diff[i];
            }
            return diff;
        }
    }
}
