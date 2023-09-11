package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 使用双指针进行反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
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
     * @param listNode
     * @return
     */
    static ListNode reverseList(ListNode listNode){
        if(listNode == null || listNode.next == null){
            return listNode;
        }
        //新链表第一个节点new1
        ListNode n1 = listNode;
        //旧链表第二个节点old2
        ListNode o2 = listNode.next;

        //直到o2==null，结束循环
        while (o2 != null){
            //1.从链表中断开o2，如1->2->3->4->5 变成1->3->4->5
            listNode.next = o2.next;
            //2.让断开的o2指向新链表头节点 2->1->3->4->5
            o2.next = n1;
            //3.n1作为新链表头部等于现在的o2
            n1 = o2;
            //4.o2指向下一个位置
            o2 = listNode.next;
        }
        return n1;
    }
}
