package com.xiaowei.algorithms.leetcode.array;

/**
 * @author weiguowei
 * leetcode 485. 最大连续 1 的个数
 * https://leetcode.cn/problems/max-consecutive-ones/
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {

        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                sum += 1;
            } else {
                sum = 0;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
