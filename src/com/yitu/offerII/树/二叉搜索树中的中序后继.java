package com.yitu.offerII.树;

import com.yitu.offerII.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/P5rCT8/
 */
public class 二叉搜索树中的中序后继 {
    /**
     * O(n)
     */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean found = false;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (found) {
                break;
            } else if (p == cur) {
                found = true;
            }
            cur = cur.right;
        }
        return cur;
    }

    /**
     * O(h)
     */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode result = null;
        while (cur != null) {
            if (cur.val > p.val) {
                result = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return result;
    }
}
