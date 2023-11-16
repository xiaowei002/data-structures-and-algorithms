package com.xiaowei.algorithms.leetcode.queue;

import com.xiaowei.datastruct.deque.impl.ArrayDeque;
import com.xiaowei.datastruct.deque.impl.LinkedListDeque;
import com.xiaowei.datastruct.queue.impl.LinkedListQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author weiguowei
 * 二叉树的z字形遍历
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //使用队列添加同一层元素
        LinkedList<TreeNode> queue = new LinkedList<>();
        //先加入根节点
        queue.offer(root);
        //记录当前层的节点个数
        int c1 = 1;
        //判断是否为奇数层
        boolean odd = true;
        while (!queue.isEmpty()) {
            //使用双端队列，来进行头尾部添加操作
            LinkedList<Integer> linkedListDeque = new LinkedList<>();
            //记录下一层节点的个数
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();//获取节点
                if (odd) {
                    linkedListDeque.offerLast(node.val);
                } else {
                    linkedListDeque.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    c2++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    c2++;
                }
            }
            odd = !odd;
            c1 = c2;
            result.add(linkedListDeque);
        }
        return result;
    }
}
