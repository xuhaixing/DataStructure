package com.xhx.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 *
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 *
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 *
 *
 * 提示：
 *
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */
public class LC870 {

    public static void main(String[] args) {
//        int[] nums1 = {2,7,11,15};
//        int[] nums2 = {1,10,4,11};

        int[] nums1 = {12, 24, 8, 32};
        int[] nums2 = {13, 25, 32, 11};
        int[] ints = new Solution().advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }


    static class Solution {
        /**
         * 二分法
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] advantageCount(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            List<Integer> nums1List = new ArrayList<>();
            for (int item : nums1) {
                nums1List.add(item);
            }
            int[] results = new int[nums1.length];
            for (int x = 0; x < nums2.length; x++) {
                int left = 0, right = nums1List.size();
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    int cur = nums1List.get(mid);
                    if (cur >= nums2[x]) {
                        right = mid;
                    } else if (cur < nums2[x]) {
                        left = mid + 1;
                    }
                }
                while (left < nums1List.size() && nums1List.get(left) <= nums2[x]) {
                    left++;
                }
                if (left < nums1List.size() && nums1List.get(left) > nums2[x]) {
                    results[x] = nums1List.get(left);
                    nums1List.remove(left);
                } else {
                    //不满足条件，放最小值
                    results[x] = nums1List.get(0);
                    nums1List.remove(0);
                }
            }
            return results;
        }

        /**
         * 比较有技巧，把nums2放到优先级队列，每次取最大值与nums1中最大值比较，
         * 比得过就上，
         * 比不过就用最小值和它比
         * @param nums1
         * @param nums2
         * @return
         */
        int[] advantageCount2(int[] nums1, int[] nums2) {
            int n = nums1.length;
            // 给 nums2 降序排序
            PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                    (int[] pair1, int[] pair2) -> {
                        return pair2[1] - pair1[1];
                    }
            );
            for (int i = 0; i < n; i++) {
                maxpq.offer(new int[]{i, nums2[i]});
            }
            // 给 nums1 升序排序
            Arrays.sort(nums1);
            // nums1[left] 是最⼩值，nums1[right] 是最⼤值
            int left = 0, right = n - 1;
            int[] res = new int[n];
            while (!maxpq.isEmpty()) {
                int[] pair = maxpq.poll();
                // maxval 是 nums2 中的最⼤值，i 是对应索引
                int i = pair[0], maxval = pair[1];
                if (maxval < nums1[right]) {
                    // 如果 nums1[right] 能胜过 maxval，那就⾃⼰上
                    res[i] = nums1[right];
                    right--;
                } else {
                    // 否则⽤最⼩值混⼀下，养精蓄锐
                    res[i] = nums1[left];
                    left++;
                }
            }
            return res;
        }
    }



}
