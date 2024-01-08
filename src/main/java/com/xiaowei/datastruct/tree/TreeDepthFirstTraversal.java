package com.xiaowei.datastruct.tree;

/**
 * @author weiguowei
 * @date 2023.12.24
 * 二叉树深度优先遍历(使用递归实现)
 */
public class TreeDepthFirstTraversal {
    static TreeNode root = new TreeNode(
            new TreeNode(new TreeNode(4),2, null),
            1,
            new TreeNode(new TreeNode(5),3,new TreeNode(6)));

    /**
     * 前序遍历
     * 根左右
     * @param root
     */
    static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //1.先访问节点的数据
        System.out.print(root.getValue()+"\t");
        //打印左节点的数据
        preOrder(root.getLeft());
        //打印右子树的数据
        preOrder(root.getRight());
    }

    /**
     * 二叉树中序遍历
     * 左根右
     * @param root
     */
    static void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //打印左子树
        midOrder(root.getLeft());
        //打印中间节点
        System.out.print(root.getValue() + "\t");
        //打印右子树
        midOrder(root.getRight());
    }

    /**
     * 二叉树后序遍历
     * 左右根
     * @param root
     */
    static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //先打印左子树
        postOrder(root.getLeft());
        //再打印右子树
        postOrder(root.getRight());
        //最后打印跟节点
        System.out.print(root.getValue() + "\t");
    }

    public static void main(String[] args) {
        //前序
        preOrder(root);
        System.out.println();
        //中序
        midOrder(root);
        System.out.println();
        //后序
        postOrder(root);
    }
}
