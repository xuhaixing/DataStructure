package com.xhx.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: xuhaixing
 * @Date: 2021/12/22 8:56 上午
 */
public class LC3 {

    public static void main(String[] args) {
//        int len = new Solution().lengthOfLongestSubstring("pwwkew");
//        int len = new Solution().lengthOfLongestSubstring("bbbbb");
        int len = new Solution().lengthOfLongestSubstring("");
//        int len = new Solution().lengthOfLongestSubstring("abcabcbb");
        System.out.println(len);
    }

    /**
     * 解法1，套用滑动窗口框架
     */
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

    /**
     * 解法2 时间复杂度较高
     */
    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            s = s + ".";
            int len = 1, tem = 0;
            int start = 0;
            for(int i = 1; i < s.length(); i++){
                for(int j = start; j < i; j++){

                    tem = i - j;
                    if(tem > len){
                        len = tem;
                    }
                    if(s.charAt(i) == s.charAt(j)){
                        start = j + 1;
                        break;
                    }

                }
            }
            return len;
        }
    }
}
