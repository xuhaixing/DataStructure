package com.xhx.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int min = new LC120().minimumTotal(triangle);
        System.out.println(min);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
//        f[0] = t[0][0]
//        f[0] = f[0]+t[1][0] f[1] = f[0]+t[1][1]
        int[] f = new int[triangle.size()];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> innerTriangle = triangle.get(i);
            for (int j = innerTriangle.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    f[j] = f[j] + innerTriangle.get(j);
                } else if (j == innerTriangle.size() - 1) {
                    f[j] = f[j-1] + innerTriangle.get(j);
                } else {
                    f[j] = innerTriangle.get(j) + Math.min(f[j], f[j - 1]);
                }
            }
        }
        int min = f[0];
        for (int i = 1; i < f.length; i++) {
            if (min > f[i]) {
                min = f[i];
            }
        }
        return min;
    }
}
