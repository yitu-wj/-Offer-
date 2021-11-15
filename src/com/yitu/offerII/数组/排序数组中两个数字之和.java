package com.yitu.offerII.数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kLl5u1/
 */
public class 排序数组中两个数字之和 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i, j};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 4, 6, 10};
        int[] ints = new 排序数组中两个数字之和().twoSum(numbers, 8);
        System.out.println(Arrays.toString(ints));
    }
}
