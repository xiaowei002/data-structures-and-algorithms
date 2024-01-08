package com.xiaowei.algorithms.leetcode.Tree;

import com.xiaowei.datastruct.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author weiguowei
 * @date 2024.1.7 22:19
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/"></a>
 * 广度优先遍历的层数即时二叉树的深度
 */
public class MaxDepthTreeBreadth {
    /**
     * 广度优先遍历
     * 思路： 从根节点开始，加入队列，然后循环从队列中获取元素
     * 每次取出一个元素后，将当前元素的子节点加入队列中
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //定义队列
        Queue<TreeNode> queue = new LinkedList<>();
        //c1记录每层的元素个数
//        int c1 = 1;
        //根节点加入队列
        queue.offer(root);
        //记录层数
        int max = 0;
        //循环条件，队列不为空
        while (!queue.isEmpty()) {
            //用于计算孩子个数
//            int c2 = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.getLeft() != null) {
                    queue.offer(poll.getLeft());
                }
                if (poll.getRight() != null) {
                    queue.offer(poll.getRight());
                }
            }
            max++;
        }
        return max;
    }
}
