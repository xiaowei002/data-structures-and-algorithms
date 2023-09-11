package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * 删除链表中倒数第N个节点
 *
 * @author weiguowei
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthFromEnd {
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
     * 递归遍历元素的顺序
     *
     * @param p 节点
     * @param n 倒数第n个节点
     * @return
     */
    private int recursionGetNumber(ListNode p, int n) {
        if (p == null) {
            return 0;
        }
        //下一个节点的倒数位置
        int nth = recursionGetNumber(p.next, n);
        if (n == nth) {
            p.next = p.next.next;
        }
        return nth + 1;
    }

    public ListNode removeNthFromEnd(ListNode p, int n) {
        ListNode s = new ListNode(-1, p);
        recursionGetNumber(s, n);
        return s.next;
    }
}
