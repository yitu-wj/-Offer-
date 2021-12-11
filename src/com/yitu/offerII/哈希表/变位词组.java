package com.yitu.offerII.哈希表;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/sfvd7V/
 */
public class 变位词组 {
    public List<List<String>> groupAnagrams1(String[] strs) {
        int[] bash = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Long, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            long wordHash = 1;
            for (int i = 0; i < str.length(); i++) {
                wordHash *= bash[str.charAt(i) - 'a'];
            }
            groups.putIfAbsent(wordHash, new LinkedList<>());
            groups.get(wordHash).add(str);
        }
        return new LinkedList<>(groups.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            groups.putIfAbsent(sorted, new LinkedList<>());
            groups.get(sorted).add(str);
        }
        return new LinkedList<>(groups.values());
    }
}
