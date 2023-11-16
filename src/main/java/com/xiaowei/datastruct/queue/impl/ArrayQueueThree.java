package com.xiaowei.datastruct.queue.impl;

import com.xiaowei.datastruct.queue.Queue;

import java.util.Iterator;

/**
 * 用环形数组创建队列(头尾指针只自增，不记录位置)
 *
 * @param <E>
 */
public class ArrayQueueThree<E> implements Queue<E>, Iterable<E> {
    /**
     * 定义环形数组
     */
    private final E[] array;

    //头指针
    private int head = 0;

    //尾指针
    private int tail = 0;

    /**
     * 带参构造
     *
     * @param capacity
     */
    @SuppressWarnings("all")
    public ArrayQueueThree(int capacity) {
        if((capacity & capacity - 1) != 0) {
             capacity = (int) ((int) Math.log10(capacity - 1) / Math.log10(2) + 1);
        }
        array = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(E e) {
        //队列满了
        if (isFull()) {
            return false;
        }
        array[tail & array.length - 1] = e;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = array[head & array.length - 1];
        head++;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head & array.length - 1];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E e = array[p & array.length - 1];
                p++;
                return e;
            }
        };
    }
}
