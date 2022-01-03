package com.xhx.lc;

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class LC27 {

    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 3};
//        int val = 3;
//        int val = 5;

        int[] nums = {1};
        int val = 1;

        int count = new Solution().removeElement(nums, val);
        System.out.println(count);
    }

    static class Solution {
        /**
         * 头尾指针
         * @param nums
         * @param val
         * @return
         */
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int slow = 0, fast = nums.length - 1;
            while (slow <= fast) {
                if (nums[slow] != val) {
                    slow++;
                } else if (nums[slow] == val) {
                    while (fast >= slow && nums[fast] == val) {
                        fast--;
                    }
                    if(fast < slow){
                        return slow;
                    }
                    nums[slow] = nums[fast];
                    fast--;
                    slow++;
                }
            }
            return slow;

        }

        /**
         * 快慢指针
         * @param nums
         * @param val
         * @return
         */
        int removeElement2(int[] nums, int val) {
            int fast = 0, slow = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }

    }
}
