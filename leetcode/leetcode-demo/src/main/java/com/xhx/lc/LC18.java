package com.xhx.lc;

import java.util.ArrayList;
import java.util.List;

public class LC18 {

    public static void main(String[] args) {
       
    }

}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int n = 0; n < length - 3; n++) {
            if (n > 0 && nums[n] == nums[n - 1]) {
                continue;
            }
            for (int i = n + 1; i <= length - 3; i++) {
                if (i > n + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1, k = length - 1;

                while (j < k) {
                    int sum = nums[n] + nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[n], nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (k > j && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (sum < target) {
                        j++;
                    } else if (sum > target) {
                        k--;
                    }
                }

            }
        }
        return result;
    }
}
