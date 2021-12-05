package com.xhx.lc;

public class LC633 {

    public static void main(String[] args) {
        System.out.println(new LC633().judgeSquareSum(4));
    }
    public boolean judgeSquareSum(int c) {
        double sqrt = Math.sqrt(c);

        if((int)sqrt == sqrt){
            return true;
        }
        int i = 1, j = (int)sqrt;
        while ( i <= j ){
            int sum = i * i + j * j;
            if( sum == c){
                return true;
            }else if(sum < c){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
