package com.xiaowei.algorithms.recursion;

import java.util.Arrays;

/**
 * @author weiguowei
 * 递归冒泡排序
 */
public class RecursionBubbleSort {

    /**
     * 递归冒泡排序，三个参数，待排序数组，起始位置，结束位置，起始和结束位置结合起来就是未排序的区域
     *
     * @param arr   待排序数组
     * @param right 结束位置
     */
    private static void bubbleSort(int[] arr, int right) {
        //此时没有待排序元素
        if (right == 0) {
            return;
        }
        //x用来记录最后一次排序的位置，只要有交换，x就是i的位置，这样，当一次排序结束之后，x后的元素就是有序的
        int x = 0;
        for (int i = 0; i < right; i++) {
            //左边大于右边，交换
            if (arr[i] > arr[i + 1]) {
                arr[i] = arr[i] ^ arr[i + 1];
                arr[i + 1] = arr[i] ^ arr[i + 1];
                arr[i] = arr[i] ^ arr[i + 1];
                x = i;
            }
        }
        //待排序元素少一个，所以结束位置减1
        bubbleSort(arr, x);
    }

    public static void sort(int[] arr) {
        bubbleSort(arr, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
