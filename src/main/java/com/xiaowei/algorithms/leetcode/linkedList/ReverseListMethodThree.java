package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 反转链表，递归实现
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class ReverseListMethodThree {
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

    static ListNode reverseList(ListNode listNode){
        //判空以及递归结束条件
        if(listNode == null || listNode.next == null){
            return listNode;
        }
        //递归遍历下一个节点
        ListNode last = reverseList(listNode.next);
        //让下一个节点指向当前节点
        listNode.next.next = listNode;
        listNode.next = null;
        return last;
    }

}
