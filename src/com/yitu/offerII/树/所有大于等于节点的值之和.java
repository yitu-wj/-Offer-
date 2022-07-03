package com.yitu.offerII.树;

import com.yitu.offerII.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/w6cpku/
 */
public class 所有大于等于节点的值之和 {
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
