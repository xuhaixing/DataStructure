package com.xhx.leetcode;

// 相邻两个元素交换
//Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes. Only nodes itself may be c
//hanged.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
//
//
// Example 2:
//
//
//Input: head = []
//Output: []
//
//
// Example 3:
//
//
//Input: head = [1]
//Output: [1]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [0, 100].
// 0 <= Node.val <= 100
//
// Related Topics Linked List
// 👍 2804 👎 185

public class LC24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode a = head;
        int tem = a.val;
        ListNode b = a.next;
        a.val = b.val;
        b.val = tem;
        ListNode c = b.next;
        while (c != null){
            a = c;
            b = c.next;
            if(b != null){
                tem = a.val;
                a.val = b.val;
                b.val = tem;
                c = b.next;
            }else {
                c = null;
            }
        }
        return head;
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
