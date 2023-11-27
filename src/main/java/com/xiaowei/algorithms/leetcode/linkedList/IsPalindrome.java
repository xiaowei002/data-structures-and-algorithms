package com.xiaowei.algorithms.leetcode.linkedList;

/**
 * @author weiguowei
 * @see <a href="https://leetcode.cn/problems/palindrome-linked-list/description/"></a>
 * 判断是否为回文链表,找到中间节点，然后中间节点之后进行反转，并与之前的比较
 */
public class IsPalindrome {


    /**
     * 1.找到中间点
     * 2.从中间点之后反转
     * 3.判断中间点前的中间点后的元素是否一样
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        //中间节点
        //慢节点
        ListNode slow = head;
        //快节点
        ListNode fast = head;
        //新链表
        ListNode n1 = null;
        //旧链表
        ListNode o1 = head;
        //寻找中间节点并反转前部分链表
        while (fast != null && fast.next != null){
            //o2 = p1
            fast = fast.next.next;
            slow = slow.next;

            //反转链表
//            ListNode o2 = o1.next;
//            o1.next = n1;
            o1.next = n1;
            n1 = o1;
            o1 = slow;
        }
//        ListNode middle = slow;
//        //从中间节点反转
//        ListNode n1 = null;
//        while (middle != null){
//            ListNode o2 = middle.next;
//            middle.next = n1;
//            n1 = middle;
//            middle = o2;
//        }
//        ListNode reverseNode = n1;
//        //比较
//        while(reverseNode != null){
//            if (reverseNode.val != head.val) {
//                return false;
//            }
//            reverseNode = reverseNode.next;
//            head = head.next;
//        }

        //考虑奇数情况
        if(fast != null){
           slow = slow.next;
        }

        //遍历链表
        while(n1 != null){
            if (n1.val != slow.val) {
                return false;
            }
            n1 = n1.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

}
