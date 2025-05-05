package com.xhx;

import java.util.LinkedList;

/**
 * 两个栈（先入后出）实现一个队列（先入先出）
 * 倒换一下
 */
public class LC232 {

    //模拟栈
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    /** Initialize your data structure here. */
    public LC232() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack2.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        convert();
        return stack1.removeLast();

    }

    /** Get the front element. */
    public int peek() {
        convert();
        return stack1.getLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        convert();
        return stack1.isEmpty();
    }

    //倒换一下
    public void convert(){
        if(stack1.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.addLast(stack2.removeLast());
            }
        }
    }

}
