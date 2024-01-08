package com.xiaowei.algorithms.leetcode.heap;

import com.xiaowei.datastruct.heap.MinHeap;

/**
 * @author weiguowei
 * @date 2023.12.17 18:23
 * 数据流中的第k大元素
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-a-stream/" />
 */
class KthLargest {
    //小顶堆
    private MinHeap minHeap;
    public KthLargest(int k, int[] nums) {
        minHeap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if(!minHeap.isFull()) {
            minHeap.offer(val);
        }else if (val > minHeap.peek()){
            minHeap.replace(val);
        }
        return minHeap.peek();
    }
}