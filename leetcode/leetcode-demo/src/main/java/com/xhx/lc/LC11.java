package com.xhx.lc;

public class LC11 {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int i = new LC11().maxArea(height);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int mArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[right], height[left]);
            mArea = Math.max(area, mArea);
            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }
        return mArea;
    }

}
