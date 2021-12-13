package com.yitu.offerII.队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/qIsx9U/
 */
public class 滑动窗口的平均值 {
    private Queue<Integer> nums;
    private int capacity;
    private int sum;

    /**
     * Initialize your data structure here.
     */
    public 滑动窗口的平均值(int size) {
        nums = new LinkedList<>();
        capacity = size;
    }

    public double next(int val) {
        nums.offer(val);
        sum += val;
        if (nums.size() > capacity) {
            sum -= nums.poll();
        }
        return (double) sum / nums.size();
    }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */