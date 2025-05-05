package com.xhx.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
 * //的三元组。
 * //
 * // 注意：答案中不可以包含重复的三元组。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * //
 * //满足要求的三元组集合为：
 * //[
 * //  [-1, 0, 1],
 * //  [-1, -1, 2]
 * //]
 * 解答失败: 测试用例:[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
 * 测试结果:[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2],[-2,-2,4],[-2,0,2]]
 * 期望结果:[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
 * 解答失败: 测试用例:[-4, -1, -1, 0, 1, 2] 测试结果:[[-1,0,1],[-1,1,0]] 期望结果:[[-1,-1,2],[-1,0,1]] stdout:
 * @description:
 * @author: 徐海兴
 * @Date: 2020/7/7 11:00
 */
public class LC15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new LC15().threeSum(nums);
        System.out.println(lists);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i <= length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (k > j && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                }
            }

        }
        return result;

    }
}
