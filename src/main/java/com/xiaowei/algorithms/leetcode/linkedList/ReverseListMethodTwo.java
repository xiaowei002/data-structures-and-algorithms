package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * 反转链表方法2:从旧链表头部获取元素，并头插法到新链表中
 * @see <a href="https://leetcode.cn/problems/reverse-linked-list/"></a>
 */
public class ReverseListMethodTwo {
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

    //构造新的list，包含头插法和尾插法
    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        /**
         * 头插法
         *
         * @param node
         */
        void addFirst(ListNode node) {
            node.next = head;
            head = node;
        }

        ListNode removeFirst() {
            ListNode removeNode = head;
            if (removeNode != null) {
                head.next = removeNode.next;
            }
            return removeNode;
        }
    }

    public static void main(String[] args) {

    }

    static ListNode reverseLinkedList(ListNode head) {
        List list = new List(head);
        List list1 = new List(null);
        while (true) {
            ListNode listNode = list.removeFirst();
            if (listNode == null) {
                break;
            }
            list1.addFirst(listNode);
        }
        return list1.head;
    }
}
