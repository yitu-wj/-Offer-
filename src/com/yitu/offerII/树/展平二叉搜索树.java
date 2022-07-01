package com.yitu.offerII.树;

import com.yitu.offerII.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/NYBBNL/
 */
public class 展平二叉搜索树 {
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (prev != null) {
                prev.right = cur;
            } else {
                first = cur;
            }
            prev = cur;
            cur.left = null;
            cur = cur.right;
        }
        return first;
    }
}
