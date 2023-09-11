package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 删除链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 */
public class DeleteDuplicates {
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
     * 删除链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head){
        //如果链表为空或者只有一个元素
        if(head == null || head.next == null){
            return null;
        }
        //p1和p2 为相邻节点
        ListNode p1 = head;
        ListNode p2;
        //循环链表
        while ((p2 = p1.next) != null){
            //不相同的话两个节点都指向下一个节点
            if(p1.val != p2.val){
                p1 = p1.next;
            }else {
                p1.next = p2.next;
            }
        }
        return head;
    }
}
