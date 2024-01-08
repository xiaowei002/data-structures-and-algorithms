package com.xiaowei.datastruct.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author weiguowei
 * @date 2023.12.24 19:06
 * 二叉树的深度优先遍历，非递归实现
 */
public class TreeDepthFirstTraversalNoRecursion {
    /**
     * 二叉树遍历，非递归核心代码实现
     * 核心逻辑，走完整个二叉树：
     * 首先走左边，从根到左，为了记录回来的路，使用栈
     * 然后根据栈最后弹出的元素，获取到右边子树
     *         //记录当前节点
     *         TreeNode curr = root;
     *         //通过栈记录回来的元素
     *         LinkedList<TreeNode> stack = new LinkedList<>();
     *         //当前节点不为空或者栈中元素不为空
     *         while (curr != null || !stack.isEmpty()) {
     *             if (curr != null) {
     *                 System.out.println("去：" + curr.getValue());//此处打印则为前序遍历
     *                 stack.push(curr);
     *                 curr = curr.getLeft();
     *             } else {
     *                 TreeNode pop = stack.pop();
     *                 System.out.println("回：" + pop.getValue());//此处打印则为中序遍历
     *                 curr = pop.getRight(); //有右子树的话
     *             }
     *         }
     *
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6)));
//        preOrder(root);
//        System.out.println();
//        midOrder(root);
//        System.out.println();
//        postOrder(root);
        System.out.println(5>>>1);
    }

    /**
     * 二叉树前序遍历
     * 根左右
     *
     * @param root
     */
    static void preOrder(TreeNode root) {
        //记录当前节点
        TreeNode curr = root;
        //通过栈记录回来的元素
        LinkedList<TreeNode> stack = new LinkedList<>();
        //当前节点不为空或者栈中元素不为空
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.print(curr.getValue() + "\t");
                stack.push(curr);
                curr = curr.getLeft();
            } else {
                TreeNode pop = stack.pop();
                curr = pop.getRight(); //有右子树的话
            }
        }
    }

    /**
     * 二叉树中序遍历
     * 左根右
     * @param root
     */
    static void midOrder(TreeNode root) {
        //记录当前节点
        TreeNode curr = root;
        //通过栈记录回来的元素
        LinkedList<TreeNode> stack = new LinkedList<>();
        //当前节点不为空或者栈中元素不为空
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            } else {
                TreeNode pop = stack.pop();
                System.out.print(pop.getValue() + "\t");
                curr = pop.getRight(); //有右子树的话
            }
        }
    }

    /**
     * 二叉树后序遍历
     * 左右根
     * @param root
     */
    static void postOrder(TreeNode root) {
        //当前节点
        TreeNode curr = root;
        TreeNode pop = null; //记录最近一次弹栈的元素
        //栈记录路径
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr); //记录路径
                curr = curr.getLeft();
            }else {
                TreeNode peek = stack.peek(); //栈顶元素
                //没有右孩子
                if (peek.getRight() == null || peek.getRight() == pop) {
                    pop = stack.pop();
                    System.out.print(pop.getValue() + "\t");
                } else {
                    curr = peek.getRight();
                }
            }
        }
    }
}
