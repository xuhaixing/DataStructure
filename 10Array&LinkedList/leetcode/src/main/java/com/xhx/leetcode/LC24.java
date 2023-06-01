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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
//        ListNode listNode = new ListNode(1, new ListNode(2, null));
        ListNode result = new LC24().swapPairs2(listNode);
        while (result != null) {
            System.out.print(result + " ");
            result = result.next;
        }
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head;
        int tem = a.val;
        ListNode b = a.next;
        a.val = b.val;
        b.val = tem;
        ListNode c = b.next;
        while (c != null) {
            a = c;
            b = c.next;
            if (b != null) {
                tem = a.val;
                a.val = b.val;
                b.val = tem;
                c = b.next;
            } else {
                c = null;
            }
        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, newHead = head.next;
        ListNode cur = head;
        //cur and next swap
        while (cur != null) {
            ListNode next = cur.next;
            ListNode nextnext = null;
            if (next != null) {
                nextnext = next.next;
            } else {
                break;
            }
            if (prev != null) {
                prev.next = next;
            }

            next.next = cur;
            cur.next = nextnext;

            prev = cur;
            cur = nextnext;
        }
        return newHead;
    }

    /**
     *  最优方案
     * @param head
     * @return
     */
    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, newHead = head.next;
        ListNode cur = head;
        //cur and next swap
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode nextnext = next.next;
            if (prev != null) {
                prev.next = next;
            }

            next.next = cur;
            cur.next = nextnext;

            prev = cur;
            cur = nextnext;
        }
        return newHead;
    }

    static class ListNode {
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

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
