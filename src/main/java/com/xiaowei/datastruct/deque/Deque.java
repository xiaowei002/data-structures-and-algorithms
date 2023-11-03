package com.xiaowei.datastruct.deque;

import com.xiaowei.datastruct.queue.Queue;

/**
 * 双端队列接口设计
 * @param <E>
 */
public interface Deque<E> {
    /**
     * 头部添加元素
     * @param value
     * @return
     */
    boolean offerFirst(E value);

    /**
     * 尾部添加元素
     * @param value
     * @return
     */
    boolean offerEnd(E value);

    /**
     * 从头部获取元素并返回
     * @return
     */
    E poolFirst();

    /**
     * 从尾部获取元素并返回
     * @return
     */
    E poolEnd();

    /**
     * 从头部获取元素不移除
     * @return
     */
    E peekFirst();

    /**
     * 从尾部获取元素不移除
     * @return
     */
    E peekEnd();

    /**
     * 是否空队列
     * @return
     */
    boolean isEmpty();

    /**
     * 队列是否满
     * @return
     */
    boolean isFull();

    /**
     * 返回队列中的元素个数
     * @return
     */
    int size();
}
