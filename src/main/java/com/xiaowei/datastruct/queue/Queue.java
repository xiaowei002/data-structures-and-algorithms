package com.xiaowei.datastruct.queue;

/**
 * 队列接口
 * @author weiguowei
 */
public interface Queue<E> {
    /**
     * 队列中的元素
     * @return
     */
    int size();

    /**
     * 队列尾部添加元素
     * @param e
     * @return
     */
    boolean offer(E e);

    /**
     * 从队列头获取元素并移除
     * @return
     */
    E poll();

    /**
     * 从队列头获取元素，不移除
     * @return
     */
    E peek();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断队列是否满了
     * @return
     */
    boolean isFull();
}
