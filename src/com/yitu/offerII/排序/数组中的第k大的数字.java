package com.yitu.offerII.排序;

import java.util.Random;

/**
 * https://leetcode.cn/problems/xx4gT2/
 */
public class 数组中的第k大的数字 {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != target) {
            if (index > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }

    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);

        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, i, small);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
}
