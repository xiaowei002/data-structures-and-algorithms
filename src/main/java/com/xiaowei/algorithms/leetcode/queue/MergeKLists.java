package com.xiaowei.algorithms.leetcode.queue;

import com.xiaowei.algorithms.leetcode.linkedList.ListNode;
import com.xiaowei.datastruct.priorityqueue.MinHeap;

/**
 * @author weiguowei
 * 合并 K 个升序链表
 * <a href="https://leetcode.cn/problems/vvXgSW/" />
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0){
            return null;
        }
        MinHeap minHeap = new MinHeap(lists.length);
        for (ListNode list : lists) {
            if(list != null) {
                minHeap.offer(list);//链表入堆
            }
        }
        ListNode sentinel = new ListNode(-1,null);

        ListNode point = sentinel;
        while (!minHeap.isEmpty()){
            ListNode poll = minHeap.poll();
            point.next = poll;
            point = poll;
            if(poll.next != null){
                minHeap.offer(poll.next);
            }
        }
        return sentinel.next;
    }

}
