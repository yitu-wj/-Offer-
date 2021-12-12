package com.yitu.offerII.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/8Zf90G/
 */
public class 后缀表达式 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(calculate(num2, num1, token));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
