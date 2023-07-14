package com.xiaowei.algorithms.leetcode.array;

/**
 * @author weiguowei
 * 26. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {
    public static void main(String[] args) {

    }

    /**
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 使用快慢指针尝试
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        //慢指针从0开始
        for (int i = 0; i < nums.length; i++) {
            //快指针从1开始
            for(int j= 1;j<nums.length;j++){
                if(nums[i] != nums[j]){
                    nums[i] = nums[j];
                }
            }
        }
        return 0;
    }
}
