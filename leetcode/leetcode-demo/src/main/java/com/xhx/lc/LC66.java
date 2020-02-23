package com.xhx.lc;

import java.util.Arrays;

public class LC66 {

    public static void main(String[] args) {
        int[] digits = new int[]{1, 9, 9, 9};
        int[] result = new LC66().plusOne(digits);
        System.out.println(Arrays.toString(result));

    }

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int now = digits[i] + carry;
            carry = now / 10;
            digits[i] = now % 10;
            if (carry == 0) {
                break;
            }
        }
        if (carry > 0) {
            int[] results = new int[digits.length + 1];
            results[0] = carry;
            System.arraycopy(digits, 0, results, 1, digits.length);
            return results;
        }
        return digits;
    }

}
