package com.xiaowei.datastruct.stack;

import java.util.Iterator;

/**
 * @param <E> 基于数组创建栈
 * @author weiguowei
 */
public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    //内置数组
    private E[] array;

    //栈顶指针
    private int top;


    //栈中的元素个数
    private int size;

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if(isFull()){
            return false;
        }
        array[top++] = value;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        return array[--top];
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[--top];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int point = top;
            @Override
            public boolean hasNext() {
                return point > 0;
            }

            @Override
            public E next() {
                return array[--point];
            }
        };
    }
}
