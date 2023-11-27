package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 删除链表中的重复元素2，重复元素都去除
 * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/"></a>
 */
public class DeleteDuplicatesLeetCode82 {

    /**
     * 使用递归删除链表中的重复元素
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head){
        if(head == null){
            return null;
        }
        //头节点
        ListNode sentinel = new ListNode(-1,head);
        ListNode p1 = sentinel;
        while(p1.next != null && p1.next.next != null){
            //相邻元素相同
            if(p1.next.val == p1.next.next.val){
                //定义相同值
                int val = p1.next.val;
                ListNode p2 = p1.next;
                while (p2 != null && p2.val == val){
                    p1.next = p2.next;
                    p2 = p2.next;
                }
            }else {
                p1 = p1.next;
            }
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);

        deleteDuplicates(listNode);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
