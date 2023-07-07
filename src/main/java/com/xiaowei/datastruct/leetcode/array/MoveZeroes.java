package com.xiaowei.datastruct.leetcode.array;

/**
 * @author weiguowei
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int index = 0;//数组下标
        for (int i = 0; i < nums.length; i++) {
            //遍历数组
            if(nums[i] != 0){
                nums[index] = nums[i];
                index ++;
            }
        }
        for(int i = index;i<nums.length;i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {

    }
}
