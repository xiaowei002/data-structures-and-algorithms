package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 反转链表双指针，从旧链表移除添加到新链表
 */
public class ReverseListMethodFive {
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

    }

    /**
     * 反转链表方法
     *
     * @param head 旧链表
     * @return
     */
    static ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //新链表的头节点 new 1
        ListNode n1 = null;
        //直到o2 == null，结束循环
        while (head != null) {
            //记录旧链表的下一个节点old2
            ListNode o2 = head.next;
            //旧链表中第一个元素指向新链表
            head.next = n1;
            //新链表头节点
            n1 = head;
            //移动旧链表第一个元素
            head = o2;
        }
        return n1;
    }

}
