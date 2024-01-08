package com.xiaowei.algorithms.leetcode.Tree;

import com.xiaowei.datastruct.tree.TreeNode;

/**
 * @author weiguowei
 * @date 2024.1.7 22:19
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/"></a>
 * 二叉树的最大深度，教材定义是从根节点到叶子节点的距离
 * 但是leetCode 是在此基础上加一，
 */
public class MaxDepthTree {
    /**
     * 思路：
     *  得到左子树深度，右子树深度，二者较大者+1就是本节点的深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //为null表示没有节点
        if (root == null) {
            return 0;
        }
        //叶子节点的判断可以在递归中进行，两个0比较之后还是0，并+1；
//        //叶子节点的深度为1
//        if (root.getLeft() == null && root.getRight() == null) {
//            return 1;
//        }
        //左子树的深度
        int left = maxDepth(root.getLeft());
        //右子树的深度
        int right = maxDepth(root.getRight());
//        return left > right ? left + 1 :right + 1;
        return Integer.max(left,right) + 1;
    }
}
