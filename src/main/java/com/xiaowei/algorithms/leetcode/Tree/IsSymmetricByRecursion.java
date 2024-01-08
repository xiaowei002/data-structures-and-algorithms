package com.xiaowei.algorithms.leetcode.Tree;


import com.xiaowei.datastruct.tree.TreeNode;

/**
 * 使用递归判断是否为对称二叉树
 * @author weiguowei
 * @date 2024.1.1
 * <a href="https://leetcode.cn/problems/symmetric-tree/"></a>
 */
public class IsSymmetricByRecursion {
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.getLeft(),root.getRight());
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        //左右都无孩子
        if (left == null && right == null) {
            return true;
        }
        //此处左/右肯定有孩子
        if (left == null || right == null) {
            return false;
        }
        if (!left.getValue().equals(right.getValue())) {
            return false;
        }
        return checkSymmetric(left.getLeft(),right.getRight()) && checkSymmetric(left.getRight(),right.getLeft());
    }
}
