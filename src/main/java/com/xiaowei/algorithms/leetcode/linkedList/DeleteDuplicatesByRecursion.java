package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 利用递归删除链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 */
public class DeleteDuplicatesByRecursion {
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
     * 利用递归删除链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesByRecursion(ListNode head){
        return null;
    }
}
