package com.xhx.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC279 {
    public static void main(String[] args) {
        int i = new LC279().numSquares(3);
        System.out.println(i);
    }

    public int numSquares(int n) {
        if(n == 0){
            return 1;
        }
        List<Integer> squareList = squares(n);
        int result = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            while (size-- > 0) {
                Integer node = queue.poll();
                for (Integer square : squareList) {
                    if (square < node) {
                        queue.add(node-square);
                    }else if(square.equals(node)) {
                        return result;
                    }else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public List<Integer> squares(int n) {
        int diff = 3;
        int s = 1;
        List<Integer> squareList = new ArrayList<>();
        while (s <= n) {
            squareList.add(s);
            s += diff;
            diff += 2;
        }
        return squareList;
    }
}
