package com.xhx.leetcode;

/**
 * 判断链表是否有环，若有环，返回环的位置
 */
public class LC142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode sp = head;
        ListNode fp = head;
        boolean flag = false;
        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            if (!flag) {
                fp = fp.next.next;
                if (sp == fp) {
                    sp = head;
                    flag = true;
                    if(sp == fp){
                        return fp;
                    }
                }
            } else {
                fp = fp.next;
                if(fp == sp){
                    return fp;
                }
            }

        }
        return null;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
