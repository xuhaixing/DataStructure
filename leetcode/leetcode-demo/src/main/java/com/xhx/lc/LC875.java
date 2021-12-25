package com.xhx.lc;

import java.util.Arrays;

/**
 * @description: 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * @author: xuhaixing
 * @Date: 2021/12/23 7:53 上午
 */
public class LC875 {

    public static void main(String[] args) {
        int count = new Solution().minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
//        int count = new Solution().minEatingSpeed(new int[]{1,1,1,999999999}, 10); //142857143
        System.out.println(count);
    }


    static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int maxPile = Arrays.stream(piles).max().getAsInt();
            int left = 1, right = maxPile;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int target = 0;
                for (int pile : piles) {
                    // 当前香蕉吃多少小时
                    target += (pile - 1) / mid + 1;
                }
                if (target == h) {
                    //求最小值
                    right = mid - 1;
                } else if (target > h) {
                    left = mid + 1;
                } else if (target < h) {
                    right = mid - 1;
                }
            }
            return left;
        }
    }


}
