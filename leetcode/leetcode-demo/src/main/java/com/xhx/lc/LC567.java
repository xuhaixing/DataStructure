package com.xhx.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 * @author: xuhaixing
 * @Date: 2021/12/21 8:56 上午
 */
public class LC567 {
    public static void main(String[] args) {
//        boolean b = new Solution().checkInclusion("ab", "aboa");
//        boolean b = new Solution().checkInclusion("adc", "dcda");
        boolean b = new Solution().checkInclusion("abcdxabcde", "abcdeabcdx");
        System.out.println(b);
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> needMap = new HashMap<>();
            Map<Character, Integer> windowMap = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                needMap.put(c, needMap.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0, valid = 0, validLength = needMap.size();
            while (right < s2.length()) {
                char rc = s2.charAt(right);
                right++;
                if (needMap.containsKey(rc)) {
                    windowMap.put(rc, windowMap.getOrDefault(rc, 0) + 1);
                    if (windowMap.get(rc).equals(needMap.get(rc))) {
                        valid++;
                    } else if (windowMap.get(rc) - needMap.get(rc) == 1) {
                        valid--;
                    }
                    if (valid == validLength) {
                        return true;
                    }
                }
                if (right - left == s1.length()) {
                    char lc = s2.charAt(left);
                    left++;
                    if (needMap.containsKey(lc)) {
                        if (windowMap.get(lc).equals(needMap.get(lc))) {
                            valid--;
                        }
                        windowMap.put(lc, windowMap.get(lc) - 1);
                        if (windowMap.get(lc).equals(needMap.get(lc))) {
                            valid++;
                        }
                    }

                }
            }
            return false;
        }
    }
}
