package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 判断链表是否有环
 * <a href="https://leetcode.cn/problems/linked-list-cycle/"></a>
 */
public class HasCycle {
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
     * 判断链表是否有环（快慢指针）
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
