package com.xiaowei.datastruct.priorityqueue;

import com.xiaowei.algorithms.leetcode.linkedList.ListNode;
import com.xiaowei.algorithms.leetcode.linkedList.ReversePrint;

/**
 * @author weiguowei
 * 小顶堆（为了方便leetcode题目，所以并未实现Queue接口）
 */
public class MinHeap {
    ListNode[] array;
    int size = 0;

    public MinHeap(int capacity) {
        array = new ListNode[capacity];
    }

    /**
     * 入堆
     *
     * @param node
     * @return
     */
    public boolean offer(ListNode node) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;

        while (child > 0 && node.val < array[parent].val) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = node;
        return true;
    }

    /**
     * 出堆
     *
     * @return
     */
    public ListNode poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);//交换堆顶和堆底
        size--;//出堆元素-1
        ListNode listNode = array[size];
        array[size] = null; //help gc

        down(0);//堆顶元素开始下潜
        return listNode;
    }

    /**
     * 堆顶元素下潜
     *
     * @param i
     */
    private void down(int i) {
        int left = (i * 2) + 1;
        int right = left + 1;

        int min = i; //假设堆底最小

        if (left < size && array[left].val < array[min].val) {//左孩子小于最小
            min = left;
        } else if (right < size && array[right].val < array[min].val) {//右孩子小于最小
            min = right;
        }

        if (min != i) { //不等于说明最小的不是min
            swap(i, min); //交换
            down(min); //递归寻最小
        }
    }

    /**
     * 交换
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        ListNode listNode = array[i];
        array[i] = array[j];
        array[j] = listNode;
    }

    /**
     * 判断是否满
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
