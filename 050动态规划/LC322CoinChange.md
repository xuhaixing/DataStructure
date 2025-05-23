You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.

Return *the fewest number of coins that you need to make up that amount*. If that amount of money cannot be made up by any combination of the coins, return `-1`.

You may assume that you have an infinite number of each kind of coin.

 

**Example 1:**

```
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

**Example 2:**

```
Input: coins = [2], amount = 3
Output: -1
```

**Example 3:**

```
Input: coins = [1], amount = 0
Output: 0
```

**Example 4:**

```
Input: coins = [1], amount = 1
Output: 1
```

**Example 5:**

```
Input: coins = [1], amount = 2
Output: 2
```

 

**Constraints:**

- `1 <= coins.length <= 12`
- `1 <= coins[i] <= 231 - 1`
- `0 <= amount <= 104`





解决方案：

```java
class Solution {
  public int coinChange(int[] coins, int amount) {
    int dp[] = new int[amount + 1];
    Arrays.fill(dp, dp.length);
    dp[0] = 0;
    //循环所有状态
    for (int i = 1; i <= amount; i++) {
      //找到每种状态最小值
      for (int coin : coins) {
        if (i < coin)
          continue;
        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}
```

