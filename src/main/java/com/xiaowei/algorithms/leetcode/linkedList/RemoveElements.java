package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 移除链表元素：利用两个指针，p1指向sentinel节点，p2指向头节点，判断p2是否与目标值相同，相同的话删除p2，不同的话p1，p2平移
 * @see <a href="https://leetcode.cn/problems/remove-linked-list-elements/"></a>
 */
public class RemoveElements {

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

    static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        //定义sentinel节点
        ListNode sentinel = new ListNode(-1, head);
        //定义两个指针
        ListNode p1 = sentinel;
        ListNode p2;

        while ((p2 = p1.next) != null) {
            if (p2.val == val) {
                //移除元素
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return sentinel.next;
    }
}
