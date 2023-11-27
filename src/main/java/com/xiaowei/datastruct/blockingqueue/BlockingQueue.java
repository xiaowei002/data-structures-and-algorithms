package com.xiaowei.datastruct.blockingqueue;

/**
 * @author weiguowei
 * 阻塞队列接口
 * @param <E>
 * 用锁保证线程安全
 * 用条件变量让poll和offer线程进入等待状态
 */
public interface BlockingQueue<E> {

    void offer(E e) throws InterruptedException;

    boolean offer(E e,long timeOut) throws InterruptedException;

    E poll() throws InterruptedException;
}
