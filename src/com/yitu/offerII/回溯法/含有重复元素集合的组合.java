package com.yitu.offerII.回溯法;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/4sjJUc/
 */
public class 含有重复元素集合的组合 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(candidates, target, 0, combination, result);
        return result;
    }

    private void helper(int[] nums, int target, int i, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(combination));
        } else if (target > 0 && i < nums.length) {
            helper(nums, target, getNext(nums, i), combination, result);

            combination.addLast(nums[i]);
            helper(nums, target - nums[i], i + 1, combination, result);
            combination.removeLast();
        }
    }

    private int getNext(int[] nums, int index) {
        int next = index;
        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }
        return next;
    }
}
