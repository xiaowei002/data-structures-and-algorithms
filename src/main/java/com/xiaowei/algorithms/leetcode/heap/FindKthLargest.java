package com.xiaowei.algorithms.leetcode.heap;

import com.xiaowei.datastruct.heap.MinHeap;

/**
 * @author weiguowei
 * @date 2023.12.17 18:02
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/"/>
 * 查找数组中第k大的元素
 * 解题思路：
 * 使用小顶堆，如果寻找第k大，则将数组中的前k个元素放在小顶堆中。
 * 数组中的其他元素的操作
 *      如果小于堆顶，则什么都不做
 *      如果大于堆顶，则替换堆顶元素并重新调整堆
 * 最后堆顶元素就是第k大的元素
 */
public class FindKthLargest {
    /**
     * 查找数组元素中第K大的元素
     * @param numbers
     * @param k
     * @return
     */
    public int findKthLargest(int[] numbers, int k) {
        MinHeap minHeap = new MinHeap(k);
        //将前k个元素加入数组
        for (int i = 0; i < k; i++) {
            minHeap.offer(numbers[i]);
        }
        //2 跳过/替换堆顶
        for (int i = k; i < numbers.length; i++) {
            //大于堆顶元素
            if (numbers[i] > minHeap.array[0]) {
                minHeap.replace(numbers[i]);
            }
        }
        return minHeap.peek();
    }
}
