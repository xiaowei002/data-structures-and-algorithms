package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 使用递归合并两个有序链表
 * @see <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/"></a>
 */
public class MergeTwoListsByRecursion {

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
     * 递归合并链表中的元素
     *
     * @param p1
     * @param p2
     * @return
     */
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p1;
        }
        if (p1.val < p2.val) {
            p1.next = mergeTwoLists(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoLists(p1, p2.next);
            return p2;
        }

    }
}
