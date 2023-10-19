package com.xiaowei.datastruct.queue;

import java.util.Collection;
import java.util.Iterator;

/**
 * 使用单项环形链表实现队列
 *
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    private static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    //定义头节点
    Node<E> head = new Node<>(null,null);

    //定义头尾指针
    Node<E> tail = head;

    //定义容量
    private int capacity = Integer.MAX_VALUE;

    //定义队列中的元素个数
    private int size = 0;

    {
        tail.next = head;
    }
    public LinkedListQueue() {}

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 队列尾部添加元素
     * @param e
     * @return
     */
    @Override
    public boolean offer(E e) {
        if(isFull()){
            return false;
        }
        Node<E> eNode = new Node<>(e,head);
        tail.next = eNode;
        tail = eNode;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        Node<E> remove = head.next;
        head.next = remove.next;
        if(remove == tail){
            tail = head;
        }
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
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> point = head.next;
            @Override
            public boolean hasNext() {
                return point != head;
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
