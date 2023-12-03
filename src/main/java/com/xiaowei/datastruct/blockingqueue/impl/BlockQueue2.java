package com.xiaowei.datastruct.blockingqueue.impl;

import com.xiaowei.datastruct.blockingqueue.BlockingQueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weiguowei
 * 2023.12.3 23:47
 * 使用双锁实现，级联调用实现优先级队列，
 */
public class BlockQueue2<E> implements BlockingQueue<E> {
    private E[] array; //数组存储元素
    //头指针
    private int head;
    //尾指针
    private int tail;
    private AtomicInteger size = new AtomicInteger();
    //头指针锁，用来poll操作使用
    private ReentrantLock headLock = new ReentrantLock();
    //头指针等待队列
    Condition headWaits = headLock.newCondition();

    //尾指针锁，用来offer操作
    private ReentrantLock tailLock = new ReentrantLock();
    //尾指针等待队列
    Condition tailWaits = tailLock.newCondition();

    @SuppressWarnings("all")
    public BlockQueue2(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    /**
     * 添加元素
     *
     * @param e
     * @throws InterruptedException
     */
    @Override
    public void offer(E e) throws InterruptedException {
        int c; //记录添加元素前的个数
        //添加操作加锁
        tailLock.lockInterruptibly();
        try {
            if (isFull()) { //如果队列满了，则等待
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            //元素个数增加
            c = size.getAndIncrement();
            //如果添加元素之后还是有空余，则唤醒其他的offer线程
            if (c + 1 < array.length) {
                tailWaits.signal();
            }
        } finally {
            tailLock.unlock();
        }
        //当队列元素添加前为空时，等添加完成后，唤醒某个poll线程
        if (c == 0) {
            //当队列添加元素之后，唤醒poll线程
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
    }

    @Override
    public boolean offer(E e, long timeOut) throws InterruptedException {
        return false;
    }

    /**
     * 移除元素
     *
     * @return
     * @throws InterruptedException
     */
    @Override
    public E poll() throws InterruptedException {
        int c; //定义移除元素前的个数
        E e; //定义返回元素
        headLock.lockInterruptibly();
        try {
            if (isEmpty()) { //如果队列为空，线程等待
                headWaits.await();
            }
            e = array[head];
            array[head] = null; //help gc
            if (++head == array.length) {
                head = 0;
            }
            //元素个数减少
            c = size.getAndDecrement();
            //当移除前队列中元素个数两个以上时，唤醒其他poll线程
            if (c > 1) {
                tailWaits.signal();
            }
        } finally {
            headLock.unlock();
        }
        //当移除前队列满时，移除后唤醒某个offer线程
        if (c == array.length) {
            //当队列获取之后，唤醒offer线程
            tailLock.lock();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }
        return e;
    }

    /**
     * 是否空
     *
     * @return
     */
    public boolean isEmpty() {
        return size.get() == 0;
    }

    /**
     * 是否满
     *
     * @return
     */
    public boolean isFull() {
        return size.get() == array.length;
    }
}
