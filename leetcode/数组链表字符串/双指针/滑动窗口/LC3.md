#### [无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

>给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
>
> 
>
>示例 1:
>
>输入: s = "abcabcbb"
>输出: 3 
>解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。



题解：滑动窗口，遇到重复元素缩小窗口

```java
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0, right = 0, max = 0, len = 0;
            Map<Character, Integer> windowMap = new HashMap<>();
            while (right < s.length()) {
                char rc = s.charAt(right);
                right++;

                while (windowMap.containsKey(rc)) {
                    windowMap.remove(s.charAt(left));
                    left++;
                    len--;
                }
                windowMap.put(rc, 1);
                len++;
                if (max < len) {
                    max = len;
                }
            }
            return max;
        }
    }
```

