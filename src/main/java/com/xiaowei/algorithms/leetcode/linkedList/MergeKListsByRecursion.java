package com.xiaowei.algorithms.leetcode.linkedList;

import static com.xiaowei.algorithms.leetcode.linkedList.MergeTwoLists.mergeTwoLists;

/**
 * @author weiguowei
 * 使用递归合并k个有序链表
 * @see <a href="https://leetcode.cn/problems/merge-k-sorted-lists/"></a>
 */
public class MergeKListsByRecursion {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return spilt(lists, 0, lists.length - 1);
    }

    /**
     * left和right代表左右边界值
     *
     * @param lists
     * @param left
     * @param right
     * @return
     */
    private ListNode spilt(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) >>> 1;
        ListNode leftListNode = spilt(lists, left, mid);
        ListNode rightListNode = spilt(lists, mid + 1, right);
        return mergeTwoLists(leftListNode, rightListNode);
    }
}
