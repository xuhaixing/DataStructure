package com.xhx;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
public class LC225 {

    private Queue<Integer> queue1 = null;
    private Queue<Integer> queue2 = null;

    /** Initialize your data structure here. */
    public LC225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {

        queue1.add(x);
        while (!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        Queue<Integer> tem = queue1;
        queue1 = queue2;
        queue2 = tem;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue2.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty();
    }

}
