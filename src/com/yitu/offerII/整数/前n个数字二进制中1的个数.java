package com.yitu.offerII.整数;

/**
 * https://leetcode-cn.com/problems/w3tCBm/
 */
public class 前n个数字二进制中1的个数 {
    public int[] countBits1(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }

    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    public int[] countBits3(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
