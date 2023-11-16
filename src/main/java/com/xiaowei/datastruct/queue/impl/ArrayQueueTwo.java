package com.xiaowei.datastruct.queue.impl;

import com.xiaowei.datastruct.queue.Queue;

import java.util.Iterator;

/**
 * 用环形数组创建队列（定义size 去判断队满和队空）
 *
 * @param <E>
 */
public class ArrayQueueTwo<E> implements Queue<E>, Iterable<E> {
    /**
     * 定义环形数组
     */
    private E[] array;

    //头指针
    private int head = 0;

    //尾指针
    private int tail = 0;

    //记录队列中的元素个数
    private int size = 0;

    @SuppressWarnings("all")
    public ArrayQueueTwo(int capacity) {
        this.array = (E[]) new Object[capacity];
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
        array[tail] = e;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = array[head];
        head = (head + 1) % array.length;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int point = head;
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < array.length -1;
            }

            @Override
            public E next() {
                E e = array[point];
                point = (point + 1) % array.length;
                count++;
                return e;
            }
        };
    }

//    //队列中的元素个数
//    private int size = 0;
//
//
//    /**
//     * 带参构造
//     *
//     * @param capacity
//     */
//    @SuppressWarnings("all")
//    public ArrayQueueTwo(int capacity) {
//        this.array = (E[]) new Object[capacity];
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public boolean offer(E e) {
//        //队列满了
//        if (isFull()) {
//            return false;
//        }
//        array[tail] = e;
//        tail = (tail + 1) % array.length;
//        size++;
//        return true;
//    }
//
//    @Override
//    public E poll() {
//        if (isEmpty()) {
//            return null;
//        }
//        E e = array[head];
//        head = (head + 1) % array.length;
//        size--;
//        return e;
//    }
//
//    @Override
//    public E peek() {
//        if (isEmpty()) {
//            return null;
//        }
//        return array[head];
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    @Override
//    public boolean isFull() {
//        return size == array.length;
//    }
//
//    @Override
//    public Iterator<E> iterator() {
//        return new Iterator<E>() {
//            int p = head;
//            int count = 0;
//            @Override
//            public boolean hasNext() {
//                return count < array.length - 1;
//            }
//
//            @Override
//            public E next() {
//                E e = array[p];
//                p = (p + 1) % array.length;
//                count++;
//                return e;
//            }
//        };
//    }
}
