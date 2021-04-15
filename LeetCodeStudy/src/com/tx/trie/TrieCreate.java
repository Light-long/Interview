package com.tx.trie;

public class TrieCreate {

    private TrieCreate[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public TrieCreate() {
        children = new TrieCreate[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        // 当前节点
        TrieCreate node = this;
        int len = word.length();
        // 遍历word
        for (int i=0;i<len;i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieCreate();
            }
            // 指向子节点
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieCreate node = searchPrefix(word);
        return node!=null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieCreate node = searchPrefix(prefix);
        return node!=null;
    }

    public TrieCreate searchPrefix(String prefix) {
        TrieCreate node = this;
        int len = prefix.length();
        for (int i=0;i<len;i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            // 没有当前节点
            if (node.children[index] == null) {
                return null;
            }
            // 指向下一个节点
            node = node.children[index];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
