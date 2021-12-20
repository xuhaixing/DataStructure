package com.xhx.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
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
