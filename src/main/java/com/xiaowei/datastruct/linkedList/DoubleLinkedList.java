package com.xiaowei.datastruct.linkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author weiguowei
 * @desc 数据结构——双向链表
 */
public class DoubleLinkedList<E> implements Iterable<E>{
    /**
     * 头节点
     */
    Node<E> head;

    /**
     * 尾节点
     */
    Node<E> tail;

    public DoubleLinkedList() {
        this.head = new Node<E>(null, null, null);
        this.tail = new Node<E>(null, null, null);
        head.next = tail;
        tail.prev = head;
    }



    //节点类
    static class Node<E> {
        //前驱
        Node<E> prev;

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
     * 头部添加元素
     *
     * @param value 元素值
     */
    public void addFirst(E value) {
        insert(0, value);
    }

    /**
     * 尾部添加元素
     * @param value 元素值
     */
    public void addLast(E value){
        Node<E> next = tail;
        Node<E> prev = next.prev;
        Node<E> eNode = new Node<>(prev, value, next);
        prev.next = eNode;
        next.prev = eNode;
    }

    /**
     * 任意索引处添加元素
     *
     * @param index 索引
     * @param value 值
     */
    public void insert(int index, E value) {
        Node<E> prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("index[%d]异常", index));
        }
        Node<E> next = prev.next;
        Node<E> eNode = new Node<>(prev, value, next);
        prev.next = eNode;
        next.prev = eNode;
    }

    /**
     * 根据索引查找对应元素
     *
     * @param index 索引
     * @return Node对象
     */
    private Node<E> findNode(int index) {
        //从头节点开始遍历
        int i = -1;
        for (Node<E> point = head; point != null; point = point.next, i++) {
            if (i == index) {
                return point;
            }
        }
        return null;
    }

    /**
     * 遍历链表（while循环）
     *
     * @param consumer 表达式
     */
    public void loopByWhile(Consumer<E> consumer) {
        Node<E> point = head.next;
        while (point != tail) {
            consumer.accept(point.value);
            point = point.next;
        }
    }

    /**
     * 遍历链表（for循环）
     *
     * @param consumer 表达式
     */
    public void loopByFor(Consumer<E> consumer) {
        for (Node<E> point = head.next; point != tail; point = point.next) {
            consumer.accept(point.value);
        }
    }

    /**
     * 迭代器遍历链表
     * @return 迭代器对象
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
     * 根据索引获取对应节点的数据
     * @param index 索引
     * @return 节点值
     */
    public E get(int index){
        Node<E> node = findNode(index);
        if(node == null){
            return null;
        }
        return node.value;
    }

    /**
     * 移除索引处的元素
     * @param index 索引位置
     */
    public void remove(int index){
        Node<E> prev = findNode(index - 1);
        if(prev == null){
            throw new IllegalArgumentException(String.format("index[%d]异常", index));
        }
        if(prev.next == tail){
            throw new IllegalArgumentException(String.format("index[%d]处无可删除元素", index));
        }
        Node<E> removed = prev.next;
        Node<E> next = removed.next;

        prev.next = next;
        next.prev = prev;
    }

    /**
     * 删除第一个节点
     */
    public void removeFirst(){
        remove(0);
    }
}
