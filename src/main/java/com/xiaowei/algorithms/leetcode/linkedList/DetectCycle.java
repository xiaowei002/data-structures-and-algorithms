package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 判断链表是否有环并返回入环点
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/"></a>
 */
public class DetectCycle {

    /**
     * 判断链表是否有环，并返回入环点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
