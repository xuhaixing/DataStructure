package com.xhx.lc;

public class LC69 {
    public static void main(String[] args) {
        System.out.println(new LC69().mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if(x <= 1){
            return x;
        }
        int l = 1, h = x/2;
        while(l <= h){
            int mid = l + (h-l)/2;
            int sqrt = x / mid;
            if(sqrt == mid){
                return mid;
            }else if(sqrt < mid){
                h = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return h;
    }
}
