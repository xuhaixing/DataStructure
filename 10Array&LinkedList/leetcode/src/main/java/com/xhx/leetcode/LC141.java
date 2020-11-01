package com.xhx.leetcode;


//判断链表是否有环,
//一个走一步，一个走两步，一定会相遇
public class LC141 {

    public boolean hasCycle(ListNode head) {
        ListNode next = head;
        while (next != null && next.next != null){
            head = head.next;
            next = next.next.next;
            if(head == next){
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
