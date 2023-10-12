package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 反转链表双指针，从旧链表移除添加到新链表
 * 类似方法二，但并不构造add/remove方法
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
     * @param o1 旧链表
     * @return
     */
    static ListNode reverseLinkedList(ListNode o1) {
        if(o1 == null || o1.next == null){
            return o1;
        }
        //定义新链表节点
        ListNode n1 = null;
        while (o1 != null){
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

}
