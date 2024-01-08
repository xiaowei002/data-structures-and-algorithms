package com.xiaowei.datastruct.tree;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

/**
 * @author weiguowei
 * @date 2023.12.24 18:41
 * 二叉树
 */
@Data
public class TreeNode {
    private TreeNode left;

    private Integer value;

    private TreeNode right;

    public TreeNode(TreeNode left, Integer value, TreeNode right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

    public TreeNode(Integer value) {
        this.value = value;
    }
}
