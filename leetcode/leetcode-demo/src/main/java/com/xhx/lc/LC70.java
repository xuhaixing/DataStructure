package com.xhx.lc;

public class LC70 {

    public static void main(String[] args) {
        int i = new LC70().climbStairs(3);
        System.out.println(i);
    }

    public int climbStairs(int n) {

        int[] steps = new int[3];
        steps[0] = 1;
        steps[1] = 2;
        if(n < 3){
            return steps[n - 1];
        }
        for (int i = 2; i < n; i++){
            steps[2] = steps[0] + steps[1];
            steps[0] = steps[1];
            steps[1] = steps[2];
        }
        return steps[1];

    }
}
