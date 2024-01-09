package com.xiaowei.algorithms.leetcode.Tree;


import java.util.LinkedList;

/**
 * @author weiguowei
 * 使用逆波兰表达式构造树
 * 思路：
 *      1.遇到数字入栈
 *      2.遇到运算符出栈，建立节点关系，先出栈的元素作为右孩子，后出栈的为左孩子，当前运算符为父节点，
 *      直到栈中只剩最后一个运算符，此符号为二叉树的根节点
 */
public class ConstructExpressionTree {

    static class TreeNode {
        TreeNode left;
        String val;
        TreeNode right;

        public TreeNode(TreeNode left, String val, TreeNode right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }

        public TreeNode(String val) {
            this.val = val;
        }
    }

    public TreeNode constructExpressionTree(String[] tokens) {
        //使用栈用于保存数据
        LinkedList<TreeNode> stack = new LinkedList<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                case "/":
                case "-":
                case "*":
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    TreeNode parent = new TreeNode(token);
                    parent.left = left;
                    parent.right = right;
                    stack.push(parent);
                    break;
                default:
                    stack.push(new TreeNode(token));
            }
        }
        return stack.pop();
    }

}
