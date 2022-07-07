package com.yitu.offerII.前缀树;

import java.util.List;

/**
 * https://leetcode.cn/problems/UhWRSj/
 */
public class 替换单词 {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = findPrefix(root, words[i]);
            if (!prefix.isEmpty()) {
                words[i] = prefix;
            }
        }
        return String.join(" ", words);
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    private String findPrefix(TrieNode root, String word) {
        TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (node.isWord || node.children[ch - 'a'] == null) {
                break;
            }
            builder.append(ch);
            node = node.children[ch - 'a'];
        }
        return node.isWord ? builder.toString() : "";
    }

    static class TrieNode {
        TrieNode children[];
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
