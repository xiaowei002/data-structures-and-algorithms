package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 删除链表的中间元素
 * @see <a href="https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/"></a>
 */
public class DeleteMiddle {
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
     * 删除链表中间元素
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //此时的slow就是中间节点
        return slow;
    }
}
