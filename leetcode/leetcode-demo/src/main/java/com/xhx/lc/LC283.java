package com.xhx.lc;

import java.util.Arrays;

public class LC283 {


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,0,0,4,5,6};
        new LC283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                count++;
                continue;
            }
            nums[i - count] = nums[i];
        }
        for(int i = 0; i < count; i++){
            nums[nums.length - 1 - i] = 0;
        }
    }
}
