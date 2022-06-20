package com.yitu.offerII.树;

import com.yitu.offerII.TreeNode;

/**
 * https://leetcode.cn/problems/h54YBf/
 */
public class 序列化与反序列化二叉树 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String lefStr = serialize(root.left);
        String rightStr = serialize(root.right);
        return root.val + "," + lefStr + "," + rightStr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeStrs = data.split(",");
        int[] i = {0};
        return dfs(nodeStrs, i);
    }

    private TreeNode dfs(String[] strs, int[] i) {
        String str = strs[i[0]];
        i[0]++;

        if (str.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = dfs(strs, i);
        node.right = dfs(strs, i);
        return node;
    }
}
