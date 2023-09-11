package com.xiaowei.algorithms.recursion;

/**
 * @author weiguowei
 * 递归二分查找
 */
public class RecursionBinarySearch {

    /**
     * 递归查找目标值
     *
     * @param arr    数组
     * @param target 目标值
     * @param left   左侧
     * @param right  右侧
     * @return
     */
    private static int recursionSearch(int[] arr, int target, int left, int right) {
        if(left > right){
            return -1;
        }
        int mid = (left + right) >>> 1;
        if (target > arr[mid]) {
           return recursionSearch(arr, target, mid + 1, right);
        } else if (target < arr[mid]) {
           return recursionSearch(arr, target, left, right - 1);
        } else {
            return mid;
        }
    }

    public static int search(int[] arr,int target){
        return recursionSearch(arr,target,0,arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(search(arr, 5));
    }
}
