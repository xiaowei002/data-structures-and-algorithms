package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 合并两个有序链表
 * @see <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/"></a>
 */
public class MergeTwoLists {

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
     * 循环合并两个链表
     * @param list1
     * @param list2
     * @return
     */
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode(-1, null);
        ListNode p = sentinel;
        //比较两个链表大小
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if(list2 != null){
            p.next = list2;
        }
        if(list1 != null){
            p.next = list1;
        }
        return sentinel.next;
    }
}
