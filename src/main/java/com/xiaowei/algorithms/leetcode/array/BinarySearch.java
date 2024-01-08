package com.xiaowei.algorithms.leetcode.array;

/**
 * 二分查找，使用0~length-1
 * @author weiguowei
 * @date 2024.1.1
 */
public class BinarySearch {
    /**
     * 范围0～（length - 1）
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        //定义左边
        int left = 0;
        //右
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 范围0～length
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        //定义左边
        int left = 0;
        //右
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
