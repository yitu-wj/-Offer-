package com.yitu.offerII.回溯法;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/Ygoe9J/
 */
public class 允许重复选择元素的组合 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(candidates, target, 0, combination, result);

        return result;
    }

    private void helper(int[] nums, int target, int i, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(combination));
        } else if (target > 0 && i < nums.length) {
            helper(nums, target, i + 1, combination, result);

            combination.add(nums[i]);
            helper(nums, target - nums[i], i, combination, result);
            combination.removeLast();
        }
    }
}
