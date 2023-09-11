package com.xiaowei.algorithms.leetcode.linkedList;

import java.util.List;

/**
 * 删除链表中倒数第N个节点
 *
 * @author weiguowei
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 * 使用快慢指针，以及两个节点，删除倒数第二个，则p1快p2 3步，当p1到null，p2为要删除的前一个节点
 */
public class RemoveNthFromEndWithFastAndSlow {
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
     * 删除链表中倒数第N个节点
     *
     * @param p
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode p, int n) {
        //哨兵
        ListNode listNode = new ListNode(-1, p);
        //快指针
        ListNode p1 = listNode;
        //慢指针
        ListNode p2 = listNode;

        //p1先走
        for (int i = 0; i <= n; i++) {
            p1 = p1.next;
        }
        //走到最后
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        //此时p2为要删除节点的前驱
        p2.next = p2.next.next;
        return listNode;
    }
}
