package com.xhx.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * @author: xuhaixing
 * @Date: 2021/12/21 10:10 下午
 */
public class LC438 {

    public static void main(String[] args) {
//        List<Integer> anagrams = new Solution().findAnagrams("cbaebabacd", "abc");
        List<Integer> anagrams = new Solution().findAnagrams("abab", "ab");
        System.out.println(anagrams);
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> needMap = new HashMap<>();
            Map<Character, Integer> windowMap = new HashMap<>();

            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                needMap.put(c, needMap.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0, valid = 0;
            List<Integer> list = new ArrayList<>();
            while (right < s.length()) {
                char rc = s.charAt(right);
                right++;
                if (needMap.containsKey(rc)) {
                    windowMap.put(rc, windowMap.getOrDefault(rc, 0) + 1);
                    if (windowMap.get(rc).equals(needMap.get(rc))) {
                        valid++;
                    }
                    if (valid == needMap.size()) {
                        list.add(left);
                    }
                }

                if (right - left == p.length()) {
                    char lc = s.charAt(left);
                    left++;

                    if (needMap.containsKey(lc)) {
                        if (windowMap.get(lc).equals(needMap.get(lc))) {
                            valid--;
                        }
                        windowMap.put(lc, windowMap.get(lc) - 1);
                    }
                }
            }
            return list;
        }
    }

}
