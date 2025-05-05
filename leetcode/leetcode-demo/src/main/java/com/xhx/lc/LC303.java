package com.xhx.lc;

/**
 * @description: 前缀和技巧
 * @author: 徐海兴
 * @Date: 2021/12/5 8:01 下午
 */
public class LC303 {
    public static void main(String[] args) {

    }
}

/**
 * 双指针/单指针，多次调用，性能较差
 */
class NumArray1 {

    int[] nums = null;

    public NumArray1(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        if (left > right || nums == null || nums.length == 0) {
            return sum;
        }

        while (left < right) {
            sum += (this.nums[left] + this.nums[right]);
            left++;
            right--;
        }
        if (left == right) {
            sum += this.nums[left];
        }
        return sum;
    }
}

/**
 * 最优解：前缀和
 */
class NumArray2 {

    int[] preSums;

    public NumArray2(int[] nums) {
        //第一个元素设置为0，因为要用preSums的right - (left - 1)，不用每次判断left-1 < 0的情况了，就变成了(right+1) - left
        this.preSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            //前i个元素的和，放到了preSums的第i个元素中
            preSums[i + 1] = preSums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSums[right + 1] - preSums[left];
    }
}