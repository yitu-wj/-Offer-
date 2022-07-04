package com.yitu.offerII.树;

import com.yitu.offerII.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/opLdQZ/
 */
public class 二叉搜索树中两个节点之和 {
    public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (set.contains(k - cur.val)) {
                return true;
            }

            set.add(cur.val);
            cur = cur.right;
        }
        return false;
    }

    public boolean findTarget2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        BSTIterator iterNext = new BSTIterator(root);
        BSTIteratorReversed iterPrev = new BSTIteratorReversed(root);
        int next = iterNext.next();
        int prev = iterPrev.prev();
        while (next != prev) {
            if (next + prev == k) {
                return true;
            }

            if (next + prev < k) {
                next = iterNext.next();
            } else {
                prev = iterPrev.prev();
            }
        }
        return false;
    }

    class BSTIterator {
        TreeNode cur;
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;

            return val;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

    class BSTIteratorReversed {
        TreeNode cur;
        Stack<TreeNode> stack;

        public BSTIteratorReversed(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        public int prev() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }

            cur = stack.pop();
            int val = cur.val;
            cur = cur.left;

            return val;
        }

        public boolean hasPrev() {
            return cur != null || !stack.isEmpty();
        }
    }
}
