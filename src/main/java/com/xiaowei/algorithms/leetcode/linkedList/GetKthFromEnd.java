package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * @author weiguowei
 */
public class GetKthFromEnd {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        //获取链表长度
        if (head == null) {
            return null;
        }
        int size = 0;
        ListNode temp = head;
        while (head != null) {
            size += 1;
            temp = temp.next;
        }

        return findNode(head, size - k);
    }

    private ListNode findNode(ListNode head, int index) {
        int i = 0;
        for (ListNode point = head; point != null; i++, point = point.next) {
            if (index == i) {
                return point;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);


        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        getKthFromEnd.getKthFromEnd(listNode, 2);
    }



}
