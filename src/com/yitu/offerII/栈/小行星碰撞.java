package com.yitu.offerII.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/XagZNi/
 */
public class 小行星碰撞 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int as : asteroids) {
            while (!stack.empty() && stack.peek() > 0 && stack.peek() < -as) {
                stack.pop();
            }
            if (!stack.isEmpty() && as < 0 && stack.peek() == -as) {
                stack.pop();
            } else if (as > 0 || stack.empty() || stack.peek() < 0) {
                stack.push(as);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
