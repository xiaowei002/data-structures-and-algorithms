package com.xiaowei.datastruct.priorityqueue.impl;

import com.xiaowei.datastruct.priorityqueue.Priority;
import com.xiaowei.datastruct.queue.Queue;

/**
 * 使用有序数组实现优先级队列
 *
 * @param <E>
 * @author weiguowei
 */
public class PriorityQueueTwo<E extends Priority> implements Queue<E> {

    private Priority[] array;

    private int size = 0;

    public PriorityQueueTwo(int capacity) {
        this.array = new Priority[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        insert(e);
        size++;
        return false;
    }

    /**
     * 将元素插入数组正确位置
     *
     * @param e
     */
    private void insert(E e) {
        int i = size -1;
        while (i >=0 && array[i].priority() > e.priority()){
            array[i+1] = array[i];
            i--;
        }
        array[i+1] = e;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = (E) array[size - 1];
        array[--size] = null; //help gc
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[size - 1];
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
