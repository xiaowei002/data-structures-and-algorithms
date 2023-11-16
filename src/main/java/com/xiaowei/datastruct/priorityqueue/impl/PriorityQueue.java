package com.xiaowei.datastruct.priorityqueue.impl;

import com.xiaowei.datastruct.priorityqueue.Priority;
import com.xiaowei.datastruct.queue.Queue;

public class PriorityQueue<E extends Priority> implements Queue<E> {
    //无序数组
    private Priority[] array;
    //数组种的元素个数
    private int size = 0;

    @Override
    public int size() {
        return 0;
    }

    public PriorityQueue(int capacity) {
        this.array = new Priority[capacity];
    }

    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        array[size++] = e;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int maxIndex = selectMaxIndex();
        E e = (E) array[maxIndex];
        remove(maxIndex);
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int maxIndex = selectMaxIndex();
        return (E) array[maxIndex];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    /**
     * 返回优先级最高的元素的下标
     *
     * @return
     */
    private int selectMaxIndex() {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (array[max].priority() < array[i].priority()) {
                max = i;
            }
        }
        return max;
    }

    /**
     * 删除索引初的元素
     *
     * @param index
     */
    private void remove(int index) {
        if (index < size - 1) {
            System.arraycopy(array, index+1, array, index, size-1-index);
        }
        array[--size] = null; //help gc
    }
}
