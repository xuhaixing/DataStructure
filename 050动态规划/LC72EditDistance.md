Given two strings `word1` and `word2`, return *the minimum number of operations required to convert `word1` to `word2`*.

You have the following three operations permitted on a word:

- Insert a character
- Delete a character
- Replace a character

 

**Example 1:**

```
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```

**Example 2:**

```
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```

 

**Example 3**

```
"dinitrophenylhydrazine"
"benzalphenylhydrazone"
7
```



**Constraints:**

- `0 <= word1.length, word2.length <= 500`
- `word1` and `word2` consist of lowercase English letters.



**解法1**

递归+备忘录 （自顶向下）

思路：

​	word1与word2某位置字母相等时->跳过  

​	不等时有三种操作：替换、插入、删除

```java

class Solution {
  private String s1;
  private String s2;
  private int[][] dp = null;
  public int minDistance(String word1, String word2) {
    if("".equals(word1)){
      return word2.length();
    } else if("".equals(word2)){
      return word1.length();
    }
    s1 = word1;
    s2 = word2;
    dp = new int[word1.length()][word2.length()];
    return convert(s1.length() - 1, s2.length() - 1);
  }

  public int convert(int i, int j) {
    if (i == -1) {
      return j + 1;
    }
    if (j == -1) {
      return i + 1;
    }
    if(dp[i][j] != 0){
      return dp[i][j];
    }
    if (s1.charAt(i) == s2.charAt(j)) {
      dp[i][j] = convert(i - 1, j - 1); //跳过
    } else {
      //三种操作 取最小值
      int t1 = convert(i - 1, j) + 1;
      int t2 = convert(i, j - 1) + 1;
      int t3 = convert(i - 1, j - 1) + 1;
      dp[i][j] = Math.min(Math.min(t1, t2), t3);
    }
    return dp[i][j];
  }
}
```



**解法2**

dp table (自底向上)

`dp[..][0]` 和 `dp[0][..]` 对应 base case

`dp[..][0]`：s1元素挨个删除

 `dp[0][..]`：s2元素挨个插入

dp 函数的 base case 是 `i,j` 等于 -1，而数组索引至少是 0，所以 dp 数组会偏移一位。

`dp[i-1][j-1]` 存储 `s1[0..i]` 和 `s2[0..j]` 的最小编辑距离

![202108122333761.jpg](./img/202108122333761.jpg)



```

class Solution {

  public int minDistance(String word1, String word2) {
    if ("".equals(word1)) {
      return word2.length();
    } else if ("".equals(word2)) {
      return word1.length();
    }
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j <= word2.length(); j++){
      dp[0][j] = j;
    }
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          int t1 = dp[i-1][j] + 1;
          int t2 = dp[i][j-1] + 1;
          int t3 = dp[i-1][j-1] + 1;
          dp[i][j] =  Math.min(Math.min(t1, t2), t3);
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }
}
```





