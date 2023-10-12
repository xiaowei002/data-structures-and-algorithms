package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 利用递归删除链表中的重复元素
 * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/"></a>
 */
public class DeleteDuplicatesByRecursion {
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
     * 利用递归删除链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesByRecursion(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        //判断当前值和下一个是否相同
        if(head.val == head.next.val){
            ListNode diff = head.next.next;
            while (diff != null && diff.val == head.val){
                diff = diff.next;
            }
            //此时的diff就是不同于head.val的第一个节点
            return deleteDuplicatesByRecursion(diff);
        }else {
            head.next = deleteDuplicatesByRecursion(head.next);
            return head;
        }
    }
}
