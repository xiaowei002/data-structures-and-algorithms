package com.xiaowei.algorithms.leetcode.queue;

import com.xiaowei.datastruct.queue.LinkedListQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weiguowei
 * 二叉树的层级遍历
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/"></a>
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void test(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        //放入根节点
        queue.offer(root);
        int c1 = 1;//当前节点
        while (!queue.isEmpty()) {
            int c2 = 0;//孩子节点树
            for (int i = 0; i < c1; i++) {
                TreeNode poll = queue.poll();
                System.out.print(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                    c2++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    c2++;
                }
            }
            c1 = c2;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(3,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null))
        );
        test(treeNode);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        //放入根节点
        queue.offer(root);
        int c1 = 1;//当前节点
        while (!queue.isEmpty()) {
            int c2 = 0;//孩子节点树
            //层级节点列表
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < c1; i++) {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                    c2++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    c2++;
                }
            }
            c1 = c2;
            result.add(level);
        }
        return result;
    }
}
