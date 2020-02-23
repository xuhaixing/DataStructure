package com.xhx.lc;

import java.util.Arrays;

public class LC455 {

    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,2};
        int count = new LC455().findContentChildren(g, s);
        System.out.println(count);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; j++){
            if(g[i] <= s[j]){
                i++;
                count++;
            }

        }
        return count;
    }
}
