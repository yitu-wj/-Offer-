package com.yitu.offerII.前缀树;

/**
 * https://leetcode.cn/problems/z1R5dt/
 */
public class 单词之和 {
}

class MapSum {
    static class TrieNode {
        public TrieNode[] children;
        public int value;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.value = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return getSum(node);
    }

    private int getSum(TrieNode node) {
        if (node == null) {
            return 0;
        }
        int result = node.value;
        for (TrieNode child : node.children) {
            result += getSum(child);
        }
        return result;
    }
}
