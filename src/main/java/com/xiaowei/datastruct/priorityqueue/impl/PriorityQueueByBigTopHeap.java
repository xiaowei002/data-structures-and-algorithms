package com.xiaowei.datastruct.priorityqueue.impl;

import com.xiaowei.datastruct.priorityqueue.Priority;
import com.xiaowei.datastruct.queue.Queue;

/**
 * @param <E>
 * @author weiguowei
 * 使用大顶堆实现优先级队列（大顶堆用数组存储，子节点索引= 父节点索引（根节点为索引0时）*2 + 1）
 */
public class PriorityQueueByBigTopHeap<E extends Priority> implements Queue<E> {
    //使用数组存储元素
    private Priority[] array;
    //元素个数
    private int size = 0;

    public PriorityQueueByBigTopHeap(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 入堆新元素
     * 加入数组末尾
     * 不断比较新元素和父节点的value
     * 如果父节点优先级低（value小）则向下移动，并找到下一个parent
     * 知道父节点优先级更高或者为child==0
     *
     * @param e
     * @return
     */
    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;

        while (array[parent].priority() < e.priority() && child > 0) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = e;
        return true;
    }

    /**
     * 首先交换堆顶和尾部元素，让尾部元素出堆
     * 然后开始下潜，从堆顶开始，将父元素和两个孩子较大者交换
     * 直到父元素大于两个孩子节点或者没有孩子节点为止
     *
     * @return
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);//交换数据
        size--;
        Priority priority = array[size];
        array[size] = null; //help gc
        down(0);

        return (E) priority;
    }

    private void swap(int i, int j) {
        Priority priority = array[j];
        array[j] = array[i];
        array[i] = priority;
    }

    /**
     * 递归下潜
     *
     * @param parent
     */
    private void down(int parent) {
        int rootLeftIndex = parent * 2 + 1;
        int rootRightIndex = rootLeftIndex + 2;
        int max = parent;//假设父元素优先级最高
        if (rootLeftIndex < size && array[max].priority() < array[rootLeftIndex].priority()) {
            max = rootLeftIndex;
        } else if (rootRightIndex < size && array[max].priority() < array[rootRightIndex].priority()) {
            max = rootRightIndex;
        }
        if (max != parent) { //有孩子大于父节点
            swap(max, parent);
            down(max);
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
