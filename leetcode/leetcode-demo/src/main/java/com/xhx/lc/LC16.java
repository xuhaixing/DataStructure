package com.xhx.lc;

import java.util.Arrays;

/**
 * //给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * // 返回这三个数的和
 * //。假定每组输入只存在唯一答案。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 输入：nums = [-1,2,1,-4], target = 1
 * //输出：2
 * //解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * @description:
 * @author: 徐海兴
 * @Date: 2020/7/7 16:32
 */
public class LC16 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        int i = new LC16().threeSumClosest(nums, target);
        System.out.println(i);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int tem = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i <= length - 3; i++) {
            int j = i + 1, k = length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if (diff < tem) {
                    tem = diff;
                    result = sum;
                }
                if(sum < target){
                    j++;
                }else if(sum == target){
                    return sum;
                }else {
                    k--;
                }
            }
        }
        return result;
    }
}
