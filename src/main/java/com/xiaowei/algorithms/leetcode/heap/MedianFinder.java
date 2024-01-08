package com.xiaowei.algorithms.leetcode.heap;

/**
 * @author weiguowei
 * @date 2023.12.18 00:07
 * <a href="https://leetcode.cn/problems/find-median-from-data-stream/"/>
 * 获取数据流中的中位数
 * 使用两个堆，将数据流分为两部分，较小的数组中的最大值和较大数组中的最小值的结果就是中位数
 * 为了保证两边数据量的平衡
 *      两边个数一致时，新元素加入左边
 *      两边个数不一致时，新元素加入右边
 *   再加入数据的时候
 *     如果在左边加入，则现将右边最小的加入左边，然后将新数据加入右边
 *     如果在右边加入，则现将左边最大的加入右边，然后将新数据加入左边
 * 获取中位数
 *      如果两边元素一致，取两个堆顶平均数
 *      如果两边元素不一致，取左边堆顶元素
 */
class MedianFinder {

    public MedianFinder() {

    }
    
    public void addNum(int num) {

    }
    
    public double findMedian() {
        return 0;
    }
}