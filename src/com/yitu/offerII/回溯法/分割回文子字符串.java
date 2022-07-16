package com.yitu.offerII.回溯法;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/M99OJA/
 */
public class 分割回文子字符串 {
    public String[][] partition(String s) {
        List<List<String>> result = new LinkedList<>();
        helper(s, 0, new LinkedList<>(), result);
        String[][] strings = new String[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            List<String> items = result.get(i);
            String[] itemsStrings = new String[items.size()];
            for (int j = 0; j < items.size(); j++) {
                itemsStrings[j] = items.get(j);
            }
            strings[i] = itemsStrings;
        }
        return strings;
    }

    private void helper(String str, int start, LinkedList<String> substrings, List<List<String>> result) {
        if (start == str.length()) {
            result.add(new LinkedList<>(substrings));
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) {
                substrings.add(str.substring(start, i + 1));
                helper(str, i + 1, substrings, result);
                substrings.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
