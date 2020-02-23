package com.xhx.lc;

public class LC136 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,2};
        System.out.println(new LC136().singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
