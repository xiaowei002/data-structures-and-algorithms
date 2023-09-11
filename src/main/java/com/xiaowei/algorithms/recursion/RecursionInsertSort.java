package com.xiaowei.algorithms.recursion;

/**
 * @author weiguowei
 * 递归插入排序
 */
public class RecursionInsertSort {

    /**
     * 从待排序数组中进行排序，将未排序区域的元素拿出来，插入到已排序数组中去，left表示未排序数组的起始位置
     *
     * @param arr  待排序数组
     * @param left left
     */
    private static void insertSort(int[] arr, int left) {
        if (left == arr.length) {
            return;
        }
        //定义临时变量存储
        int t = arr[left];
        //表示已存储的右边界
        int i = left - 1;

        //没有找到
        while (i >= 0 && arr[i] > t) {
            arr[i + 1] = arr[i];
            i--;
        }

        //找到之后
        if (i + 1 != left) {
            arr[i + 1] = t;
        }


        insertSort(arr, left + 1);
    }

    public void sort(int[] arr) {
        insertSort(arr, 1);
    }
}
