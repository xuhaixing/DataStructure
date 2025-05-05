[903范围加法](https://www.lintcode.com/problem/903/)

同LC370

>描述
>
>假设你有一个长度为`n`的数组，数组的所有元素初始化为`0`，并且给定`k`个更新操作。
>
>每个更新操作表示为一个三元组：`[startIndex, endIndex, inc]`。这个更新操作给子数组 `A[startIndex ... endIndex]`（包括startIndex和endIndex）中的每一个元素增加 `inc`。
>
>返回执行`k`个更新操作后的新数组。
>
>样例
>
>```
>给定：
>长度 = 5,
>更新操作 = 
>[
>[1,  3,  2],
>[2,  4,  3],
>[0,  2, -2]
>]
>返回 [-2, 0, 3, 5, 3]
>
>解释:
>初始状态：
>[ 0, 0, 0, 0, 0 ]
>完成 [1, 3, 2]操作后：
>[ 0, 2, 2, 2, 0 ]
>完成[2, 4, 3]操作后：
>[ 0, 2, 5, 5, 3 ]
>完成[0, 2, -2]操作后：
>[-2, 0, 3, 5, 3 ]
>```
>
>



套差分数组模板：

```java
public void increment(int i, int j, int val) {
   diff[i] += val;
   if (j + 1 < diff.length) {
   		diff[j + 1] -= val;
   }
}
```



```java
    /**
     * 差分数组技巧 O(length)时间复杂度
     */
    static class Solution2 {
        public int[] getModifiedArray(int length, int[][] updates) {

            int[] diff = new int[length];

            for (int i = 0; i < updates.length; i++) {
                diff[updates[i][0]] += updates[i][2];
                if (updates[i][1] + 1 < length) {
                    diff[updates[i][1] + 1] -= updates[i][2];
                }
            }
            for (int i = 1; i < diff.length; i++) {
                diff[i] = diff[i - 1] + diff[i];
            }
            return diff;
        }
    }
```

