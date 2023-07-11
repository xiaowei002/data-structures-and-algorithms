package com.xiaowei.datastruct.linkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author weiguowei
 * @desc 双向循环链表
 * @Date 2023.7.10
 */
public class CircularLinkedList<E> implements Iterable<E> {

    //头节点
    Node<E> head;

    //尾节点
    Node<E> tail;

    public CircularLinkedList() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(head, null, head);
        head.prev = tail;
        head.next = tail;
    }


    static class Node<E> {
        //前驱
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

    /**
     * 通过索引查找元素
     *
     * @param index 索引
     * @return
     */
    private Node<E> findNode(int index) {
        int i = -1;
        for (Node<E> point = head; point != tail; point = point.next, i++) {
            if (i == index) {
                return point;
            }
        }
        return null;
    }

    /**
     * 在索引处添加元素
     *
     * @param index 索引
     * @param value 元素值
     */
    public void insert(int index, E value) {
        //前一个元素
        Node<E> prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index[%d]不合法", index));
        }
        //后一个元素
        Node<E> next = prev.next;

        Node<E> eNode = new Node<>(prev, value, next);
        prev.next = eNode;
        next.prev = eNode;
    }

    /**
     * 头插法
     *
     * @param value
     */
    public void addFirst(E value) {
        insert(0, value);
    }

    /**
     * 尾插法
     *
     * @param value
     */
    public void addLast(E value) {
        Node<E> next = tail;
        Node<E> prev = next.prev;
        Node<E> node = new Node<E>(prev, value, next);
        prev.next = node;
        next.prev = node;
    }

    /**
     * 使用while循环遍历链表
     *
     * @param consumer
     */
    public void loopByWhile(Consumer<E> consumer) {
        Node<E> point = head.next;
        while (point != tail) {
            consumer.accept(point.value);
            point = point.next;
        }
    }

    /**
     * 使用for循环遍历链表
     *
     * @param consumer
     */
    public void loopByFor(Consumer<E> consumer) {
        for (Node<E> point = head.next; point != tail; point = point.next) {
            consumer.accept(point.value);
        }
    }

    /**
     * 迭代器遍历
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> point = head.next;

            @Override
            public boolean hasNext() {
                return point != tail;
            }

            @Override
            public E next() {
                E value = point.value;
                point = point.next;
                return value;
            }
        };
    }

    /**
     * 根据索引获取元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        Node<E> node = findNode(index);
        return node == null ? null : node.value;
    }

    /**
     * 删除索引位置处的节点
     *
     * @param index
     */
    public void remove(int index) {
        Node<E> prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index[%d]不合法", index));
        }

        Node<E> removed = prev.next;
        if (removed == tail) {
            throw new IllegalArgumentException("链表为空，无元素可删除");
        }
        Node<E> next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     *
     * 头部删除元素
     */
    public void removeFirst() {
        remove(0);
    }
}
