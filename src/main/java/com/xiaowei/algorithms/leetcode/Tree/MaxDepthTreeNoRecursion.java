package com.xiaowei.algorithms.leetcode.Tree;

import com.xiaowei.datastruct.tree.TreeNode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author weiguowei
 * @date 2024.1.7 22:19
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/"></a>
 * 二叉树的最大深度，教材定义是从根节点到叶子节点的距离（非递归求解）
 * 但是leetCode 是在此基础上加一，
 */
public class MaxDepthTreeNoRecursion {
    /**
     * 思路：
     *  得到左子树深度，右子树深度，二者较大者+1就是本节点的深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //定义当前节点用于递归
        TreeNode currentNode = root;
        //定义栈保存链路以及栈中元素为某条链路的深度
        LinkedList<TreeNode> stack = new LinkedList<>();
        //用于判断当前节点是否处理完左右子节点（最近一次的弹栈元素）
        TreeNode pop = null;

        //用于定义最大深度
        int max = 0;

        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                if (max < stack.size()) {
                    max = stack.size();
                }
                currentNode = currentNode.getLeft();
            } else {
                //栈顶元素
                TreeNode peek = stack.peek();
                if (peek.getRight() == null || peek.getRight() == pop) {
                    pop = stack.pop();
                } else {
                    currentNode = peek.getRight();
                }
            }
        }
        return max;
    }
}
