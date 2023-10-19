package com.xiaowei.datastruct.queue;

import java.util.Iterator;

/**
 * 用环形数组创建队列
 *
 * @param <E>
 */
public class CycleArrayQueue<E> implements Queue<E>, Iterable<E> {

    //定义环型数组
    private E[] array;

    //定义头指针
    private int head = 0;

    //定义尾指针
    private int tail = 0;


    @SuppressWarnings("all")
    public CycleArrayQueue(int capacity) {
        this.array = (E[]) new Object[capacity + 1];
    }

    @Override
    public int size() {
        return 0;
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
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

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
                point = (point + 1) % array.length;
                return e;
            }
        };
    }
//    /**
//     * 定义环形数组
//     */
//    private E[] array;
//
//    //头指针
//    private int head = 0;
//
//    //尾指针
//    private int tail = 0;
//
//    /**
//     * 带参构造
//     *
//     * @param capacity
//     */
//    @SuppressWarnings("all")
//    public ArrayQueue(int capacity) {
//        this.array = (E[]) new Object[capacity + 1];
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
//        return head == tail;
//    }
//
//    @Override
//    public boolean isFull() {
//        return (tail + 1) % array.length == head;
//    }
//
//    @Override
//    public Iterator<E> iterator() {
//        return new Iterator<E>() {
//            int p = head;
//
//            @Override
//            public boolean hasNext() {
//                return p != tail;
//            }
//
//            @Override
//            public E next() {
//                E e = array[p];
//                p = (p + 1) % array.length;
//                return e;
//            }
//        };
//    }
}
