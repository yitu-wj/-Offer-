package com.yitu.offerII.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/iIQa4I/
 */
public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                result[prev] = i - prev;
            }
            stack.push(i);
        }
        return result;
    }
}
