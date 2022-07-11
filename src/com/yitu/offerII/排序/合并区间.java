package com.yitu.offerII.排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/SsGoHC/
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> merged = new LinkedList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] temp = new int[]{intervals[i][0], intervals[i][1]};
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[j][1]);
                j++;
            }
            merged.add(temp);
            i = j;
        }

        int[][] result = new int[merged.size()][];
        return merged.toArray(result);
    }
}
