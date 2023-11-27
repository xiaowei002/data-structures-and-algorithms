package com.xiaowei.algorithms.leetcode.linkedList;
/**
 * @author weiguowei
 * @see <a href="https://leetcode.cn/problems/delete-node-in-a-linked-list/"></a>
 * 删除链表中的节点，这个题目的核心解题思路在于，我想干掉我自己，那先把我变成别人（我的值等于别人的值）然后在把别人删除掉
 * 比如有个链表 4->5->1->9
 * 我想删除5，我自己，我先把我的值变成1，再把后边一个1删掉就好了
 */
public class DeleteNode {

    /**
     * 删除给定节点
     * @param node 要删除的节点
     */
    public void deleteNode(ListNode node) {
        if(node != null && node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

}
