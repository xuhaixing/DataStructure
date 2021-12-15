package com.xhx.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: LintCode 903
 * @author: xuhaixing
 * @Date: 2021/12/13 10:34 下午
 * 描述
 * 假设你有一个长度为n的数组，数组的所有元素初始化为0，并且给定k个更新操作。
 * <p>
 * 每个更新操作表示为一个三元组：[startIndex, endIndex, inc]。这个更新操作给子数组 A[startIndex ... endIndex]
 * （包括startIndex和endIndex）中的每一个元素增加 inc。
 * <p>
 * 返回执行k个更新操作后的新数组。
 */
public class LC370 {
    /**
     * 暴力O(i*(end-start))，会超时
     */
    static class Solution {
        /**
         * @param length:  the length of the array
         * @param updates: update operations
         * @return: the modified array after all k operations were executed
         */
        public int[] getModifiedArray(int length, int[][] updates) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < updates.length; i++) {
                int start = updates[i][0];
                int end = updates[i][1];
                int inc = updates[i][2];

                while (start <= end) {
                    map.put(start, map.getOrDefault(start, 0) + inc);
                    start++;
                }
            }
            int[] result = new int[length];
            for (int i = 0; i < length; i++) {
                result[i] = map.getOrDefault(i, 0);
            }
            return result;
        }
    }

    /**
     * 差分数组技巧 O(length)时间复杂度
     */
    static class Solution2 {
        public int[] getModifiedArray(int length, int[][] updates) {

            int[] diff = new int[length];

            for (int i = 0; i < updates.length; i++) {
                diff[updates[i][0]] += updates[i][2];
                if (updates[i][1] + 1 < length) {
                    diff[updates[i][1] + 1] -= updates[i][2];
                }
            }
            for (int i = 1; i < diff.length; i++) {
                diff[i] = diff[i - 1] + diff[i];
            }
            return diff;
        }
    }
}
