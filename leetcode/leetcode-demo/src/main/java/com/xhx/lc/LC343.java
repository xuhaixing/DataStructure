package com.xhx.lc;

public class LC343 {
    public static void main(String[] args) {
        LC343 lc343 = new LC343();
        System.out.println(lc343.integerBreak(10));
    }

    public int integerBreak(int n) {
        int[] bp = new int[n + 1];
        bp[1] = 1;
        bp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                bp[i] = Math.max(bp[i], Math.max(j * bp[i - j], j *(i - j)));
            }
        }
        return bp[n];
    }
}
