package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * 使用递归删除链表中的元素
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * @author weiguowei
 * 相等返回后续节点
 * 不想等返回自身并更新next
 */
public class RemoveElementsByRecursion {

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
     *
     * @param p 节点
     * @param val 目标值
     * @return
     */
    public ListNode removeElementsByRecursion(ListNode p,int val){
        if(p == null){
            return null;
        }else if(p.val != val){
            return removeElementsByRecursion(p.next,val);
        }else {
            return removeElementsByRecursion(p.next,val);
        }
    }

}
