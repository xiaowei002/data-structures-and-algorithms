package com.xiaowei.datastruct.stack;

/**
 * @author weiguowei
 * 栈数据结构接口
 * @param <E>
 */
public interface Stack<E> {
    /**
     * 向栈顶添加元素
     * @param value
     * @return
     */
    boolean push(E value);

    /**
     * 从栈顶获取元素并移除
     * @return
     */
    E pop();

    /**
     * 从栈顶获取元素不返回
     */
    E peek();

    /**
     * 判断栈是否空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断栈是否满
     * @return
     */
    boolean isFull();

    /**
     * 栈中元素的个数
     * @return
     */
    int size();
}
