package com.yitu.offerII.字符串;

/**
 * https://leetcode-cn.com/problems/RQku0D/
 */
public class 最多删除一个字符得到回文 {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        for (; start < s.length() / 2; ++start, --end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
        }
        return start == s.length() / 2
                || isPalindrome(s, start, end - 1)
                || isPalindrome(s, start + 1, end);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        return start >= end;
    }

    public static void main(String[] args) {
        boolean result = new 最多删除一个字符得到回文().validPalindrome("deeee");
        System.out.println(result);
    }
}
