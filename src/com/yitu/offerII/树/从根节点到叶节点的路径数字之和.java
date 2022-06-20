package com.yitu.offerII.树;

import com.yitu.offerII.TreeNode;

/**
 * https://leetcode.cn/problems/3Etpl5/
 */
public class 从根节点到叶节点的路径数字之和 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }
        path = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            return path;
        }
        return dfs(root.left, path) + dfs(root.right, path);
    }
}
