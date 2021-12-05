package com.xhx.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC406 {

    public static void main(String[] args) {
        int[][] people = new int[][]{
                {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
        };
        new LC406().reconstructQueue(people);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (b[0] > a[0]) {
                return 1;
            } else if (b[0] == a[0] && a[1] > b[1]) {
                return 1;
            } else if (b[0] == a[0] && b[1] == a[1]) {
                return 0;
            }
            return -1;
        });
        int[][] tem = new int[1][];
        for (int i = 0; i < people.length; i++) {
            tem[0] = people[i];
            System.arraycopy(people, people[i][1], people, people[i][1] + 1, i - people[i][1]);
            System.arraycopy(tem, 0, people, tem[0][1], 1);
        }
        return people;

//        int[][] results = new int[people.length][];
//        for (int i = 0; i < people.length; i++) {
//            System.arraycopy(results, people[i][1], results, people[i][1] +1,i - people[i][1]);
//            System.arraycopy(people, i, results, people[i][1], 1 );
//        }
//        return results;


//        List<int[]> results = new ArrayList<>();
//        for (int[] person : people) {
//            results.add(person[1],person);
//        }
//        return results.toArray(new int[people.length][2]);
    }
}
