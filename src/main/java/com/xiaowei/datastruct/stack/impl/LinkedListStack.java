package com.xiaowei.datastruct.stack.impl;

import com.xiaowei.datastruct.stack.Stack;

import java.util.Iterator;

/**
 * @author weiguowei
 * 基于单向链表创建栈
 */
public class LinkedListStack<E> implements Stack<E>, Iterable<E> {
    /**
     * 单向链表节点
     * @param <E>
     */
    static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    //栈大小
    private int capacity;

    //栈中元素个数
    private int size;

    //哨兵节点
    private Node<E> head = new Node<>(null,null);

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E value) {
        if(isFull()){
            return false;
        }
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        Node<E> remove = head.next;
        head.next = remove.next;
        size--;
        return remove.value;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> point = head.next;
            @Override
            public boolean hasNext() {
                return point != null;
            }

            @Override
            public E next() {
                E value = point.value;
                point = point.next;
                return value;
            }
        };
    }
}
