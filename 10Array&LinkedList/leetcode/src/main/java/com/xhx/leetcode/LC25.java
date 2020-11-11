package com.xhx.leetcode;

/**
 * 给一个链表，每k个节点一组进行反转，输出反转后的链表
 */
public class LC25 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode result = new LC25().reverseKGroup(listNode, 2);
       while (result!=null){
           System.out.print(result);
           result = result.next;
       }
    }

    /**
     * k个元素一组做划分
     * 每组进行反转（需要记录每组的头[达到分组条件时需要用到这个头进行循环当前组]）
     * 反转后的尾与反转后的头连接（需要记录上一组反转后的尾[也就是未反转时的头]）
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }
        //迭代数量
        int n = 0;
        //记录每一段的第一个
        ListNode first = head;
        //记录上一段第一个
        ListNode lastFirst = null;
        //临时循环变量，分组用[达到分组条件时，为当前组的最后一个]
        ListNode tem = first;
        //记录第一组的尾[反转后整个链表的头]
        ListNode tail = null;
        while (tem != null) {
            n++;
            //满足分组条件
            if (n == k) {
                //达到k，重置
                n = 0;
                ListNode middle = first.next;
                //上一段头，指向新一段尾
                if(lastFirst != null) {
                    lastFirst.next = tem;
                }
                lastFirst = first;
                //指针变换，first middle last依次后移
                while (middle != null && middle != tem) {
                    ListNode last = middle.next;
                    middle.next = first;
                    first = middle;
                    middle = last;
                }
                if(tail == null){
                    //记录第一组的尾
                    tail = tem;
                }
                tem = tem.next;
                //当前组最后两元素变换指针
                middle.next = first;
                first = tem;
                continue;
            }
            tem = tem.next;
        }
        //最后一组未满足k个元素时，元素做关联
        lastFirst.next = first;
        return tail;
    }

    public static class ListNode {
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
            return val+" ";
        }
    }

}
