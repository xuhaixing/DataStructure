## 887. Super Egg Drop 高楼扔鸡蛋

You are given `k` identical eggs and you have access to a building with `n` floors labeled from `1` to `n`.

You know that there exists a floor `f` where `0 <= f <= n` such that any egg dropped at a floor **higher** than `f` will **break**, and any egg dropped **at or below** floor `f` will **not break**.

Each move, you may take an unbroken egg and drop it from any floor `x` (where `1 <= x <= n`). If the egg breaks, you can no longer use it. However, if the egg does not break, you may **reuse** it in future moves.

Return *the **minimum number of moves** that you need to determine **with certainty** what the value of* `f` is.

 

**Example 1:**

```
Input: k = 1, n = 2
Output: 2
Explanation: 
Drop the egg from floor 1. If it breaks, we know that f = 0.
Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
If it does not break, then we know f = 2.
Hence, we need at minimum 2 moves to determine with certainty what the value of f is.
```

**Example 2:**

```
Input: k = 2, n = 6
Output: 3
```

**Example 3:**

```
Input: k = 3, n = 14
Output: 4
```

 

**Constraints:**

- `1 <= k <= 100`
- `1 <= n <= 104`



求最坏情况下，最少尝试次数



```java

/**
 * k = 1 return n
 * n = 0 return 0
 */
class Solution {
  public int superEggDrop(int k, int n) {
    //k个鸡蛋，n层楼，最坏情况下，最小次数
    int[][] dp = new int[k + 1][n + 1];

    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == 1) {
          //1个鸡蛋时，只能从第一层开始试，所以返回楼层数
          dp[i][j] = j;
        } else if (j == 1) {
          //1个楼层时，始终是1次
          dp[i][j] = 1;
        } else {

          //超时
         /* dp[i][j] = Integer.MAX_VALUE;
          // 1-j层做选择，碎或不碎
          for (int m = 1; m <= j; m++) {
            int max = Integer.max(dp[i - 1][m - 1], dp[i][j - m]) + 1;
            dp[i][j] = Integer.min(dp[i][j], max);
          }*/

          //二分法
          int start = 1;
          int end = j;
          int ans = Integer.MAX_VALUE;
          while (start < end) {
            int mid = start + (end - start) / 2;

            int left = dp[i - 1][mid - 1];
            int right = dp[i][j - mid];
            ans = Math.min(Math.max(left, right), ans);
            if (left == right) {
              break;
            }
            if (left < right) {
              start = mid + 1;
            } else {
              end = mid;
            }
          }
          dp[i][j] = ans + 1;
        }
      }
    }
    return dp[k][n];
  }
}
```



