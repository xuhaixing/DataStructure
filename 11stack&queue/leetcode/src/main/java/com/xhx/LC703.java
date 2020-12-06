package com.xhx;

import java.util.PriorityQueue;

/**
 *
 */
public class LC703 {

    public static void main(String[] args) {

    }

    static class KthLargest {
        private int k;
        private PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.queue = new PriorityQueue<>((a, b) -> a - b);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.add(val);
            } else {
                Integer head = queue.peek();
                if (head >= val) {
                    return head;
                }
                queue.poll();
                queue.add(val);
            }
            return queue.peek();
        }
    }
}
