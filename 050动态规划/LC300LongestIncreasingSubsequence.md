

Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

A **subsequence** is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, `[3,6,2,7]` is a subsequence of the array `[0,3,1,6,2,2,7]`.

 

**Example 1:**

```
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
```

**Example 2:**

```
Input: nums = [0,1,0,3,2,3]
Output: 4
```

**Example 3:**

```
Input: nums = [7,7,7,7,7,7,7]
Output: 1
```

 

1. 默认初始化bp为1
2. bp[i]代表以nums[i]结尾的值的最长递增子序列长度
3. bp[n] =max{bp[n-m]+1|nums[n]<nums[n-m]}

```java
class Solution {
  public int lengthOfLIS(int[] nums) {
    int[] bp = new int[nums.length];
    for(int i = 0; i < bp.length; i++){
      bp[i] = 1;
    }
    for(int i = 1; i < nums.length; i++){
      for(int j = i - 1; j >=0; j--){
        if(nums[j] < nums[i]){
          bp[i] = Math.max(bp[j]+1, bp[i]);
        }
      }
    }
    int max = bp[0];
    for(int i = 1; i < bp.length; i++){
      max = Math.max(max, bp[i]);
    }
    return max;
  }
}
```

