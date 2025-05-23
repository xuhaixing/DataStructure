package com.xhx.leetcode;

// 206 反转链表
//Reverse a singly linked list.
//
// Example:
//
//
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
//
//
// Follow up:
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both?
// Related Topics Linked List

public class LC206 {

    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode head1 = head;
        ListNode head2 = head.next;
        ListNode head3 = head2.next;
        head2.next = head1;
        head1.next = null;
        if (head3 == null) {
            return head2;
        }
        while (head3 != null) {
            head1 = head2;
            head2 = head3;
            head3 = head3.next;
            head2.next = head1;
        }
        head3.next = head2;
        return head3;

    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next, pre = head;
        head.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 最简洁
     */
    public ListNode reverseList3(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

