package com.yitu.offerII.堆;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/jBjn9C/
 */
public class 数据流的第K大数值 {
    class KthLargest {
        private PriorityQueue<Integer> minHeap;
        private int size;

        public KthLargest(int k, int[] nums) {
            size = k;
            minHeap = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (minHeap.size() < size) {
                minHeap.offer(val);
            } else if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
            return minHeap.peek();
        }
    }
}
