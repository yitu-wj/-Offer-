package com.yitu.offerII.堆;

import java.util.*;

/**
 * https://leetcode.cn/problems/qn8gGX/
 */
public class 和最小的k个数对 {
    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] + o2[1] - o1[0] - o1[1]);
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                if (maxHeap.size() >= k) {
                    int[] root = maxHeap.peek();
                    if (root[0] + root[1] > nums1[i] + nums2[j]) {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i], nums2[j]});
                    }
                } else {
                    maxHeap.offer(new int[]{nums1[i], nums2[j]});
                }
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            int[] values = maxHeap.poll();
            result.add(Arrays.asList(values[0], values[1]));
        }
        return result;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        if (nums2.length > 0) {
            for (int i = 0; i < Math.min(k, nums1.length); i++) {
                minHeap.offer(new int[]{i, 0});
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] ids = minHeap.poll();
            result.add(Arrays.asList(nums1[ids[0]], nums2[ids[1]]));

            if (ids[1] < nums2.length - 1) {
                minHeap.offer(new int[]{ids[0], ids[1] + 1});
            }
        }
        return result;
    }
}
