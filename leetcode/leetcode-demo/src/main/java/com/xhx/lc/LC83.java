package com.xhx.lc;

import com.xhx.lc.utils.ListNode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 */
public class LC83 {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null) {
                if (slow.val != fast.val) {
                    slow.next = fast;
                    slow = slow.next;
                }
                fast = fast.next;
            }
            if (slow != null) {
                slow.next = null;
            }
            return head;
        }
    }
}
