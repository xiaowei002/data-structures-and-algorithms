package com.xiaowei.datastruct.deque.impl;

import com.xiaowei.datastruct.deque.Deque;

import java.util.Iterator;

/**
 * 使用双向循环链表
 *
 * @param <E>
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    private static class Node<E> {
        //前区
        Node<E> prev;
        //值
        E value;
        //后继
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    //头节点
    private Node<E> head = new Node<>(null, null, null);

    //元素个数
    private int size = 0;

    //队列大小
    private int capacity = Integer.MAX_VALUE;

    {
        head.prev = head;
        head.next = head;
    }


    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
    }

    public LinkedListDeque() {
    }

    @Override
    public boolean offerFirst(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> eNode = new Node<>(head, value, head.next);
        head.next.prev = eNode;
        head.next = eNode;
        size++;
        return true;
    }

    @Override
    public boolean offerEnd(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> eNode = new Node<>(head.prev, value, head);
        head.prev.next = eNode;
        head.prev = eNode;
        size++;
        return true;
    }

    @Override
    public E poolFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removed = head.next;
        head.next = removed.next;
        removed.next.prev = head;
        size--;
        return removed.value;
    }

    @Override
    public E poolEnd() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removed = head.prev;
        Node<E> prev = removed.prev;
        head.prev = prev;
        prev.next = head;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public E peekEnd() {
        if (isEmpty()) {
            return null;
        }
        return head.prev.value;
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
