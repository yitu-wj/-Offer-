package com.yitu.offerII.整数;

/**
 * https://leetcode-cn.com/problems/xoh6Oh/
 */
public class 整数除法 {
    public int divide(int dividend, int divisor) {
        // dividend     被除数
        // divisor      除数
        // 0x80000000为最小的 int 型整数，即 -2^31，0xc0000000是它的一半，即 -2^30
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        int result = divideCore(dividend, divisor);
        // 符号判断，只有被除数和除数属于一正，一负，才进行符号的翻转
        return negative == 1 ? -result : result;
    }

    private int divideCore(int dividend, int divisor) {
        int result = 0;
        // 被除数和除数已经被转换成负数进行计算，如果 被除数 > 除数 结果为 0
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            // 如果 value < 0xc0000000，那么 value + value 将会导致溢出
            while (value >= 0xc0000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = new 整数除法().divide(8, 5);
        System.out.println(result);
    }
}
