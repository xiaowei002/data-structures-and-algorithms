package com.xiaowei.datastruct.linkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author weiguowei
 * @desc 带哨兵的单向链表
 */
public class SinglyLinkedListWithSentinel<E> implements Iterable<E> {
    private Node<E> head = new Node<E>();


    private static class Node<E> {
        E value;
        Node<E> next;

        public Node() {
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 在头部添加节点
     *
     * @param value
     */
    public void addFirst(E value) {
        insert(0, value);
    }

    /**
     * 末尾添加元素
     *
     * @param value
     */
    public void addLast(E value) {
        Node<E> point = head;
        while (point.next != null) {
            point = point.next;
        }
        point.next = new Node<>(value, null);
    }

    /**
     * 在索引处添加元素
     *
     * @param index
     * @param value
     */
    public void insert(int index, E value) {
        Node<E> prev = findNode(index - 1);
        prev.next = new Node<>(value, prev.next);
    }

    /**
     * @param index
     * @return
     */
    private Node<E> findNode(int index) {
        int i = -1;
        for (Node<E> point = head; point != null; point = point.next, i++) {
            if (i == index) {
                return point;
            }
        }
        throw new IllegalArgumentException(String.format("index[%s] 不合法", index));
    }

    /**
     * 根据索引查找元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        Node<E> node = findNode(index);
        if (node == null) {
            throw new IllegalArgumentException(String.format("index[%s] 不合法", index));
        }
        return node.value;
    }

    /**
     * 删除头一个元素
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 删除索引位置的元素
     *
     * @param index
     */
    public void remove(int index) {
        Node<E> prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index[%s] 不合法", index));
        }
        prev.next = prev.next.next;
    }


    /**
     * while循环遍历链表
     *
     * @param consumer
     */
    public void loopByWhile(Consumer<E> consumer) {
        while (head.next != null) {
            consumer.accept(head.next.value);
            head.next = head.next.next;
        }
    }

    /**
     * for循环遍历链表
     *
     * @param consumer
     */
    public void loopByFor(Consumer<E> consumer) {
        for (Node<E> point = head.next; point != null; point = point.next) {
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
