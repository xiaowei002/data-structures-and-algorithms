package com.xiaowei.datastruct.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * 使用单项环形链表实现队列
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E>,Iterable<E> {
    //内部节点类
    private static class Node<E>{
         E value;
         Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
    //头节点
    Node<E> head = new Node<>(null,null);
    Node<E> tail = head;

    public LinkedListQueue() {
        tail.next = head;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    /**
     * 遍历队列
     * @return
     */
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

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    /**
     * 在队列尾部添加元素
     * @param e the element to add
     * @return
     */
    @Override
    public boolean offer(E e) {
        Node<E> eNode = new Node<>(e, head);
        tail.next = eNode;
        tail = eNode;
        return true;
    }

    @Override
    public E remove() {
        return null;
    }

    /**
     * 获取队列第一个元素的值，并移除
     * @return
     */
    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        Node<E> next = head.next;
        head.next = next.next;
        if(next == tail){
            tail = head;
        }

        return next.value;
    }

    @Override
    public E element() {
        return null;
    }

    /**
     * 获取队列头元素，不移除
     * @return
     */
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return head.next.value;
    }
}
