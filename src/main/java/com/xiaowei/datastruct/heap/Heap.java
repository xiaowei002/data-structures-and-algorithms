package com.xiaowei.datastruct.heap;

/**
 * @author weiguowei
 * @date 2023.12.18 00:23
 * 通过传入的参数判断是大顶堆还是小顶堆
 */
public class Heap {
    int array[];
    int size;
    boolean max;

    public int size() {
        return size;
    }

    public Heap(int capacity, boolean max) {
        this.array = new int[capacity];
        this.max = max;
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peek() {
        return array[0];
    }

    /**
     * 删除堆顶元素
     * @return
     */
    public int poll() {
        swap(0, size-1);
        return 0;
    }


    /**
     * 交换索引i和j处的元素
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }


    /**
     * 替换堆顶元素
     * @param replaced
     */
    public void replace(int replaced){
        array[0] = replaced;
    }

    /**
     * 堆空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 堆满
     */
    public boolean isFull() {
        return size == array.length;
    }
}
