package com.xhx.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * @author: xuhaixing
 * @Date: 2021/12/20 9:59 下午
 */
public class LC76 {

    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> needMap = new HashMap<>();
            Map<Character, Integer> windowMap = new HashMap<>();

            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                needMap.put(c, needMap.getOrDefault(c, 0) + 1);
            }

            int length = s.length();
            int i = 0, j = 0;
            int valid = 0, start = 0, len = Integer.MAX_VALUE;
            while (j < length) {
                //窗口右移
                char c = s.charAt(j);
                j++;

                //若满足条件，更新数据状态
                if (needMap.containsKey(c)) {
                    windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                    if (windowMap.get(c).equals(needMap.get(c))) {
                        valid++;
                    }
                }

                //是否满足缩减窗口条件
                while (valid == needMap.size()) {
                    if (j - i < len) {
                        start = i;
                        len = j - i;
                    }

                    //缩减窗口
                    char rc = s.charAt(i);
                    i++;

                    //缩减后更新数据状态
                    if (needMap.containsKey(rc)) {
                        if (windowMap.get(rc).equals(needMap.get(rc))) {
                            valid--;
                        }
                        windowMap.put(rc, windowMap.get(rc) - 1);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
}
