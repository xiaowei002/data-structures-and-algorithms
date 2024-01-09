package com.xiaowei.algorithms.leetcode.Tree;

import com.xiaowei.datastruct.tree.TreeNode;

/**
 * @author weiguowei
 * 翻转二叉树
 * <a href="https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/description/"></a>
 * 使用递归实现
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        fn(root);
        return root;
    }

    /**
     * 翻转某一个节点
     * @param node
     */
    private static void fn(TreeNode node) {
        if (node == null) {
            return;
        }

        //左孩子存储在临时变量里

        //交换左右节点
        TreeNode temp = node.getRight();
        node.setRight(node.getLeft());
        node.setLeft(temp);
        //递归左孩子和右孩子
        fn(node.getRight());
        fn(node.getLeft());
    }
}
