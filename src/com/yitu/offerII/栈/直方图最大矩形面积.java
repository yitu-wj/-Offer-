package com.yitu.offerII.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/0ynMMM/
 */
public class 直方图最大矩形面积 {
    /**
     * 超出时间限制
     */
    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                int area = min * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    /**
     * 超出时间限制
     */
    public int largestRectangleArea2(int[] heights) {
        return helper(heights, 0, heights.length);
    }

    private int helper(int[] heights, int start, int end) {
        if (start == end) {
            return 0;
        }

        if (start + 1 == end) {
            return heights[start];
        }

        int minIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }

        int area = (end - start) * heights[minIndex];
        int left = helper(heights, start, minIndex);
        int right = helper(heights, minIndex + 1, end);

        area = Math.max(area, left);
        return Math.max(area, right);
    }

    public int largestRectangleArea3(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}
