package com.yitu.offerII.字符串;

/**
 * https://leetcode-cn.com/problems/wtcaE1/
 */
public class 不含重复字符的最长子字符串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] counts = new int[256];
        int i = 0;
        int j = -1;
        int longest = 1;
        int countDup = 0;
        for (; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            if (counts[s.charAt(i)] == 2) {
                countDup++;
            }
            while (countDup > 0) {
                j++;
                counts[s.charAt(j)]--;
                if (counts[s.charAt(j)] == 1) {
                    countDup--;
                }
            }
            longest = Math.max(i - j, longest);
        }
        return longest;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        int i = 0;
        int j = -1;
        int longest = 1;
        for (; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            while (hasGreaterThan1(counts)) {
                j++;
                counts[s.charAt(j)]--;
            }
            longest = Math.max(i - j, longest);
        }
        return longest;
    }

    private boolean hasGreaterThan1(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}
