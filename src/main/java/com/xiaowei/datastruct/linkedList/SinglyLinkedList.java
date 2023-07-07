package com.xiaowei.datastruct.linkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author weiguowei
 * @date 2023.6.20
 * @desc 单向链表
 */
public class SinglyLinkedList<E> implements Iterable<E> {
    /**
     * 头节点
     */
    Node<E> head;


    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 在头部插入元素
     *
     * @param value
     */
    public void addFirst(E value) {
        head = new Node<>(value, head);
    }

    /**
     * 在尾部插入元素
     *
     * @param value
     */
    public void addLast(E value) {
        //头节点
        Node<E> point = head;
        //链表为空
        if (point == null) {
            addFirst(value);
            return;
        }

        //链表不为空先找到最后一个元素
        Node<E> node = new Node<>(value, null);
        while (point.next != null) {
            point = point.next;
        }
        point.next = node;
    }

    /**
     * 根据索引获取数据
     *
     * @param index
     * @return
     */
    public E get(int index) {
        Node<E> node = findNode(index);
        if (node == null) {
            illegalArgumentException(index);
        }
        return node.value;
    }

    /**
     * 抛出异常
     *
     * @param index
     */
    private static void illegalArgumentException(int index) {
        throw new IllegalArgumentException(String.format("参数异常：index[%d]", index));
    }

    /**
     * 在任意节点插入元素
     *
     * @param index
     * @param value
     */
    public void insert(int index, E value) {
        //头部添加元素
        if (index == 0) {
            addFirst(value);
            return;
        }
        //找到前一个元素
        Node<E> prev = findNode(index - 1);
        if (prev == null) {
            illegalArgumentException(index);
        }

        prev.next = new Node<>(value, prev.next);
    }

    /**
     * 返回节点对象
     *
     * @param index
     * @return
     */
    private Node<E> findNode(int index) {
        //记录索引
        int i = 0;
        for (Node<E> point = head; point != null; point = point.next, i++) {
            if (index == i) {
                return point;
            }
        }
        return null;
    }

    /**
     * while循环遍历单链表
     *
     * @param consumer
     */
    public void loopByWhile(Consumer<E> consumer) {
        Node<E> point = head;
        while (point != null) {
            consumer.accept(point.value);
            point = point.next;
        }
    }

    /**
     * for循环遍历单链表
     *
     * @param consumer
     */
    public void loopByFor(Consumer<E> consumer) {
        for (Node<E> point = head; point != null; point = point.next) {
            consumer.accept(point.value);
        }
    }

    /**
     * 删除第一个元素
     */
    public void removeFirst() {
        if (head == null) {
            throw new RuntimeException("链表中没有元素");
        }
        head = head.next;
    }

    /**
     * 删除索引处的元素
     *
     * @param index
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        //待删除元素前一个节点
        Node<E> prev = findNode(index - 1);
        if (prev == null) {
            illegalArgumentException(index);
        }
        prev.next = prev.next.next;
    }

    /**
     * 迭代器遍历链表
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> point = head;

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

