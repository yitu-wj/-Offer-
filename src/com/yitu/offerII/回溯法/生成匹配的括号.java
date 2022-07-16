package com.yitu.offerII.回溯法;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/IDBivT/
 */
public class 生成匹配的括号 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        helper(n, n, "", result);
        return result;
    }

    private void helper(int left, int right, String parenthesis, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(parenthesis);
            return;
        }

        if (left > 0) {
            helper(left - 1, right, parenthesis + "(", result);
        }
        if (left < right) {
            helper(left, right - 1, parenthesis + ")", result);
        }
    }
}
