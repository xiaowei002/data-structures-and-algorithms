package com.xiaowei.datastruct.linkedList;

/**
 * @author weiguowei
 * @desc 数据结构——双向链表
 */
public class DoubleLinkedList<E> {


    //节点类
    static class Node<E>{
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
}
