package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 使用双指针进行反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 * 双指针思路：n1作为新链表头部，o1为旧链表头部，o2为旧链表第二个节点，
 * 每次将o2 从旧链表剪切，并将o2指向n1，然后更新n1为头，让o2 继续变为旧链表第二个节点，以此往复，直到o2等于null
 */
public class ReverseListMethodFour {
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
     * 使用双指针反转链表
     * @param o1
     * @return
     */
    static ListNode reverseList(ListNode o1){
        //边界条件
        if(o1 == null || o1.next == null){
            return o1;
        }
        //定义新链表n1
        ListNode n1 = o1;
        //定义旧链表第二个元素
        ListNode o2 = o1.next;
        while(o2 !=null){
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }
}
