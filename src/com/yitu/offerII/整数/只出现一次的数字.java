package com.yitu.offerII.整数;

/**
 * https://leetcode-cn.com/problems/WGki4K/
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int[] bitSums = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitSums[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1, 0, 1, 100};
        int result = new 只出现一次的数字().singleNumber(nums);
        System.out.println(result);
    }
}
