package com.xiaowei.datastruct.leetcode.array;

import java.util.Arrays;

/**
 * @author weiguowei
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                temp++;
                nums[i] = nums[temp];
            }

        }
        return temp;
    }
}
