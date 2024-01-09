package com.xiaowei.algorithms.leetcode.Tree;

import com.xiaowei.datastruct.tree.TreeNode;

import java.util.Arrays;

/**
 * @author weiguowei
 * 根据二叉树的前序遍历和中序遍历构造二叉树 或者根据中序遍历和后序遍历构造二叉树
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/"></a>
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/"></a>
 */
public class BuildTree {
    /**
     * 根据二叉树的前序遍历和中序遍历构造二叉树
     * @param preorder 前序结果
     * @param inorder 中序结果
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        //创建根节点
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        //区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                //从0～i-1 是左子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                //i+1～inorder.length - 1 是右子树
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                //前序遍历左右子树
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, inorder.length);

                root.setLeft(buildTree(preLeft, inLeft)); //
                root.setRight(buildTree(preRight, inRight)); //
            }
        }
        return root;
    }

    /**
     * 根据中序遍历和后序遍历构造二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTreeByPostAndIn(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        //获取根节点，后序遍历的最后一个节点为根节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);

        //区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                //从0 ～ i 是inorder左子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                //从i+1 ～ inorder.length - 1 是inorder 的右子树
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                //postorder的左子树
                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                //postorder的右子树
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);

                root.setLeft(buildTreeByPostAndIn(inLeft, postLeft));
                root.setRight(buildTreeByPostAndIn(inRight, postRight));
            }
        }
        return root;
    }
}
