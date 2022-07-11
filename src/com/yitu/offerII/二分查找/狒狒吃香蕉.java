package com.yitu.offerII.二分查找;

/**
 * https://leetcode.cn/problems/nZZqjQ/
 */
public class 狒狒吃香蕉 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = getHours(piles, mid);
            if (hours <= h) {
                if (mid == 1 || getHours(piles, mid - 1) > h) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int getHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }
}
