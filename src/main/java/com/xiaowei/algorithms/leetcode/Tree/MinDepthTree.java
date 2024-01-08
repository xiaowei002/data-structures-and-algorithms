package com.xiaowei.algorithms.leetcode.Tree;

import com.xiaowei.datastruct.tree.TreeNode;

/**
 * @author weiguowei
 * @date 2024.1.7 22:19
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/"></a>
 * 二叉树的最小深度
 *
 */
public class MinDepthTree {
    /**
     * 思路：
     *  得到左子树深度，右子树深度，二者较小者+1就是本节点的深度
     *  需要考虑左子树/右子树为空的情况
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        //为null表示没有节点
        if (root == null) {
            return 0;
        }
        //左子树的深度
        int left = minDepth(root.getLeft());
        //右子树的深度
        int right = minDepth(root.getRight());
        //左子树为空
        if (left == 0) {
            return right + 1;
        }
        //右子树为空
        if (right == 0) {
            return left + 1;
        }
        return Integer.min(left,right) + 1;
    }
}
