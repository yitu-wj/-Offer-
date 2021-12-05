package com.yitu.offerII.字符串;

/**
 * https://leetcode-cn.com/problems/XltzEq/
 */
public class 有效的回文 {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (!Character.isLetterOrDigit(ch1)) {
                i++;
            } else if (!Character.isLetterOrDigit(ch2)) {
                j--;
            } else {
                ch1 = Character.toLowerCase(ch1);
                ch2 = Character.toLowerCase(ch2);
                if (ch1 != ch2) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new 有效的回文().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }
}
