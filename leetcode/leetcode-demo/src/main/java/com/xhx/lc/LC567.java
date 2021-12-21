package com.xhx.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: xuhaixing
 * @Date: 2021/12/21 8:56 上午
 */
public class LC567 {

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> needMap = new HashMap<>();
            Map<Character, Integer> windowMap = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                needMap.put(c, needMap.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0, valid = 0;
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
                    if (valid == s1.length()) {
                        return true;
                    }
                }
                if (right - left == s1.length()) {
                    char lc = s2.charAt(left);
                    left++;
                    if (needMap.containsKey(lc)) {
                        windowMap.put(lc, windowMap.get(lc) - 1);
                        if (windowMap.get(lc).equals(needMap.get(lc))) {
                            valid--;
                        }
                    }

                }
            }
            return false;
        }
    }
}
