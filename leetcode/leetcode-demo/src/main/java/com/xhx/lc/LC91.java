package com.xhx.lc;

public class LC91 {
    public static void main(String[] args) {

        int i = new LC91().numDecodings("110");
        System.out.println(i);

    }

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0') {
                    return 0;
                }
                if (i - 2 < 0) {
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else {
                if (i - 2 < 0) {
                    if (s.substring(i - 1, i + 1).compareTo("26") > 0) {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1] + 1;
                    }
                } else {
                    if (s.charAt(i - 1) == '0') {
                        dp[i] = dp[i - 1];
                    } else {
                        if (s.substring(i - 1, i + 1).compareTo("26") > 0) {
                            dp[i] = dp[i - 1];
                        } else {
                            dp[i] = dp[i - 1] + dp[i - 2];
                        }
                    }

                }
            }
        }
        return dp[s.length() - 1];

    }
}
