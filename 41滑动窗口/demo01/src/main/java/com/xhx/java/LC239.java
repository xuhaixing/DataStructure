package com.xhx.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Sliding Window Maximum
 * 滑动窗口取最大值
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 * 双端队列， 队列中做多保持k个元素的下标
 * 每加一个元素前
 *  - 判断下标，不合适的remove
 *  - 判断元素，比新添加元素小的remove
 */
public class LC239 {

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = new int[]{1,3,1,2,0,5};
        int[] ints = new LC239().maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 1) {
            return nums;
        }
        int[] results = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (!deque.isEmpty()) {
                if (deque.peek() == i - k) {
                    deque.remove();
                }
                while ( !deque.isEmpty() && nums[deque.peekLast()] < item) {
                    deque.removeLast();
                }
            }
            deque.offer(i);
            if (i + 1 >= k) {
                results[i - k + 1] = nums[deque.peek()];
            }
        }
        return results;

    }

}
