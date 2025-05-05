package com.xhx.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * @author: xuhaixing
 * @Date: 2021/12/9 8:30 上午
 */
public class LC560 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // 0 0 0  0     1 1 1  1    0 0 1  1     0, 1, 1  1     -1, 1, 1 1
        int[] nums = {0, 0, 0};
        int count = solution.subarraySum(nums, 0);
        System.out.println(count);
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] sums = new int[nums.length + 1];
            //计算出前缀和
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
            int count = 0;
            //sums[j] - sums[i] 计算是否=k?
            for (int i = 1; i < sums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (k == sums[i] - sums[j]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    static class Solution2 {
        public static int subarraySum(int[] nums, int k) {
            int sum = 0;
            int res = 0;
            Map<Integer, Integer> preSum = new HashMap<>();
            //当第一次出现sum - k == 0，此时preSum中key = 0,value=0，计算结果就会少算一个，所以需要初始化此值为1
            preSum.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                // 判断是否存在和为sum - k的连续式数组，如果存在，那么一定存在和为k的连续数组
                // 每次都是从数组起始位置累加的
                if (preSum.containsKey(sum - k)) {
                    res += preSum.get(sum - k);
                }
                //赋值为啥不放在if前面，难道不会把当前漏算了吗？ 如果漏算那么存在sum-k == sum成立，此时k == 0，
                // 因为开始preSum初始化了key=0,value=1，所以放在前面会多算一个，要放在if后面
                // 如果不存在sum-k的连续子数组，则将sum的连续子数组存进preSum里
                preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }
}



