package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 反转链表方法1:构造一个新链表，然后从旧链表中依次获取节点并使用头插法插入新链表
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class ReverseListMethodOne {

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
        //新链表
        ListNode newNode = null;
        ListNode point = head;
        while (point != null) {
            newNode = new ListNode(point.val, newNode);
            point = point.next;
        }
        return newNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        System.out.println(listNode);
        ListNode listNode1 = reverseLinkedList(listNode);
        System.out.println(listNode1);
    }
}
