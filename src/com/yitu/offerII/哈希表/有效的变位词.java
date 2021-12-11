package com.yitu.offerII.哈希表;

/**
 * https://leetcode-cn.com/problems/dKk3P7/
 */
public class 有效的变位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (counts[c - 'a'] == 0) {
                return false;
            }
            counts[c - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new 有效的变位词().isAnagram("anagram", "nagaram");
        System.out.println(result);
    }
}
