package com.yitu.offerII.树;

import com.yitu.offerII.TreeNode;

/**
 * https://leetcode.cn/problems/pOCWxh/
 */
public class 二叉树剪枝 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}
