package com.xhx.lc;

import org.junit.Test;

/**
 * @description:
 * @author: xuhaixing
 * @Date: 2021/12/14 11:08 下午
 */
public class LC1904 {

    @Test
    public void test01(){
        Solution solution = new Solution();
        solution.numberOfRounds("12:01", "12:59");
    }



    class Solution {
        public int numberOfRounds(String startTime, String finishTime) {
            String[] start = startTime.split(":");
            String[] end = finishTime.split(":");

            Integer startHour = Integer.valueOf(start[0]);
            Integer startMin = Integer.valueOf(start[1]);

            Integer endHour = Integer.valueOf(end[0]);
            Integer endMin = Integer.valueOf(end[1]);

            if(endHour < startHour)

            return 0;
        }
    }
}
