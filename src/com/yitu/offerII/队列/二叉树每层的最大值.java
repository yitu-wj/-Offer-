package com.yitu.offerII.队列;

import com.yitu.offerII.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/hPov7L/
 */
public class 二叉树每层的最大值 {
    public List<Integer> largestValues1(TreeNode root) {
        int current = 0;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            current = 1;
        }

        List<Integer> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            max = Math.max(max, node.val);

            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }

            if (current == 0) {
                result.add(max);
                max = Integer.MIN_VALUE;
                current = next;
                next = 0;
            }
        }
        return result;
    }

    public List<Integer> largestValues2(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root != null) {
            queue1.offer(root);
        }

        List<Integer> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            max = Math.max(max, node.val);

            if (node.left != null) {
                queue2.offer(node.left);
            }

            if (node.right != null) {
                queue2.offer(node.right);
            }

            if (queue1.isEmpty()) {
                result.add(max);
                max = Integer.MIN_VALUE;

                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }
}
