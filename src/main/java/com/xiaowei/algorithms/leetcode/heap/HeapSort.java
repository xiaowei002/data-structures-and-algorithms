package com.xiaowei.algorithms.leetcode.heap;

import com.xiaowei.datastruct.heap.MaxHeap;

/**
 * 堆排序，使用堆的heapify 方法构建堆，然后每次交换跟节点和最后一个元素，然后调整堆
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 7, 6, 4, 5};
        MaxHeap maxHeap = new MaxHeap(array);

        while (maxHeap.size > 1) {
            //交换
            maxHeap.swap(0, maxHeap.size - 1);
            maxHeap.size --;
            maxHeap.down(0);
        }
    }
}
