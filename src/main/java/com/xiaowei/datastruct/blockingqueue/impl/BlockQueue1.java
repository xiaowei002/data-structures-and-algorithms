package com.xiaowei.datastruct.blockingqueue.impl;

import com.xiaowei.datastruct.blockingqueue.BlockingQueue;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单锁实现阻塞队列
 *
 * @param <E>
 * @author weiguowei
 */
public class BlockQueue1<E> implements BlockingQueue<E> {

    private E[] array;
    private int head;
    private int tail;
    private int size;
    //可重入锁，用来保证线程安全
    private ReentrantLock lock = new ReentrantLock();
    //队列为空时等待条件
    private Condition headWaits = lock.newCondition();

    //队列满时等待条件
    private Condition tailWaits = lock.newCondition();

    @SuppressWarnings("all")
    public BlockQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    /**
     * 阻塞队列入队操作
     *
     * @param e
     * @throws InterruptedException
     */
    @Override
    public void offer(E e) throws InterruptedException {
        lock.lockInterruptibly();//加锁（可打断）
        try {
            while (isFull()) { //while防止虚假唤醒
                tailWaits.await(); //等待
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();//唤醒poll方法中的等待
        } finally {
            lock.unlock();
        }
    }

    /**
     * 阻塞队列入队（时间限制）
     *
     * @param e
     * @param timeOut 超时时间（在时间超出后返回） 毫秒
     * @return
     * @throws InterruptedException
     */
    @Override
    public boolean offer(E e, long timeOut) throws InterruptedException {
        lock.lockInterruptibly();//加锁（可打断）
        try {
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeOut);
            while (isFull()) { //while防止虚假唤醒
                if(nanos <= 0){
                    return false;
                }
                nanos = tailWaits.awaitNanos(nanos); //等待nanos毫秒，返回值为剩余时间
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();//唤醒poll方法中的等待
            return true;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 阻塞队列出队操作
     *
     * @return
     * @throws InterruptedException
     */
    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty()) { //队列为空等待
                headWaits.await();
            }
            E e = array[head]; //移除元素
            array[head] = null;//help gc;
            if (++head == array.length) {
                head = 0;
            }
            size--;
            headWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
