package com.xiaowei.algorithms.leetcode.linkedList;

import com.xiaowei.datastruct.linkedList.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Offer 06. 从尾到头打印链表
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author weiguowei
 */
public class ReversePrint {

    List<Integer> list = new ArrayList<>();

    /**
     * Definition for singly-linked list
     */
     static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public  int[] reversePrint(ListNode head) {
        traverse(head);
        int[] res = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
     void traverse(ListNode head){
        if(head == null){
            return;
        }
        traverse(head.next);
        list.add(head.val);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ReversePrint print = new ReversePrint();
        print.reversePrint(listNode);
    }

}
