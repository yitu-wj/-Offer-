package com.yitu.offerII.堆;

import java.util.*;

/**
 * https://leetcode.cn/problems/g5c51o/
 */
public class 出现频率最高的k个数字 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        int size = minHeap.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            result[i] = entry.getKey();
        }
        return result;
    }
}
