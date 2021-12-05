package com.xhx.lc;

public class LC167 {

    public static void main(String[] args) {
        LC167 lc167 = new LC167();
        int[] ints = lc167.twoSum(new int[]{-1, 1, 2, 3}, 3);
        System.out.println(ints[0] + "   " + ints[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0, j = numbers.length - 1; i < numbers.length && i < j; i++) {
            if (numbers[i] > target) {
                return null;
            }
            while (numbers[i] + numbers[j] > target) {
                j--;
                if (j <= 0) {
                    break;
                }
            }
            if (numbers[i] + numbers[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }
}
