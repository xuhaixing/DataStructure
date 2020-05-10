package com.xhx.lc;


public class LC5 {

    public static void main(String[] args) {
        String babad = new LC5().longestPalindrome("abba");
        System.out.println(babad);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        boolean[][] mins = new boolean[s.length()][s.length()];
        int maxLen = 0;
        String maxStr = null;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i + len <= s.length(); i++) {
                int j = i + len - 1;
                if (len == 1) {
                    mins[i][j] = true;
                } else if (len == 2) {
                    mins[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    mins[i][j] = s.charAt(i) == s.charAt(j) && mins[i + 1][j - 1];
                }

                if (mins[i][j] && len > maxLen) {
                    maxLen = len;
                    maxStr = s.substring(i, i + len);
                }
            }
        }
        return maxStr;

    }

}
