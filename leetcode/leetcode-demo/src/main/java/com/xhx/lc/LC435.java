package com.xhx.lc;

import java.util.Arrays;

public class LC435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int count = 1;

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(end > intervals[i][0]){
                continue;
            }
            count++;
            end = intervals[i][1];
        }

        return intervals.length - count;
    }
}
