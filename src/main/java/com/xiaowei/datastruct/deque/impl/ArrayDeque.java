package com.xiaowei.datastruct.deque.impl;

import com.xiaowei.datastruct.deque.Deque;

import java.util.Iterator;

/**
 * 基于环形数组实现队列
 *
 * @param <E>
 */
public class ArrayDeque<E> implements Deque<E>, Iterable<E> {
    //数组
    private final E[] array;
    //头指针
    private int head = 0;
    //尾指针
    private int tail = head;


    @SuppressWarnings("all")
    public ArrayDeque(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    /*
     0    1    2     3    4
     b                    a
                        head
    tail
     */
    @Override
    public boolean offerFirst(E value) {
        if (isFull()) {
            return false;
        }
        head = decrementIndex(head);
        array[head] = value;
        return true;
    }

    @Override
    public boolean offerEnd(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = incrementIndex(tail);
        return true;
    }

    @Override
    public E poolFirst() {
        if (isEmpty()) {
            return null;
        }
        E e = array[head];
        array[head] = null;
        head = incrementIndex(head);
        return e;
    }

    @Override
    public E poolEnd() {
        if (isEmpty()) {
            return null;
        }
        tail = decrementIndex(tail);
        E e = array[tail];
        array[tail] = null;
        return e;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public E peekEnd() {
        if (isEmpty()) {
            return null;
        }
        tail = decrementIndex(tail);
        return array[tail];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        if(head > tail){
            return head - tail == 1;
        }else if(tail > head){
            return (tail - head) == array.length - 1;
        }else {
            return false;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * 索引自增方法
     *
     * @param count
     * @return
     */
    private int incrementIndex(int count) {
        count++;
        if (count == array.length) {
            count = 0;
        }
        return count;
    }

    /**
     * 索引自减方法
     *
     * @param count
     * @return
     */
    private int decrementIndex(int count) {
        if (count == 0) {
            count = array.length - 1;
        } else {
            count--;
        }
        return count;
    }

    /**
     * 迭代器
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int point = head;
            @Override
            public boolean hasNext() {
                return point != tail;
            }

            @Override
            public E next() {
                E e = array[point];
                point = incrementIndex(point);
                return e;
            }
        };
    }
}
