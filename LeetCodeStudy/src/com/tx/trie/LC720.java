package com.tx.trie;

import java.util.HashMap;

public class LC720 {
    public String longestWord(String[] words) {
        if (words == null || words.length==0) return "";
        Trie root = new Trie();
        // 遍历所有的单词，将每个单词放入前缀树
        for (String word : words) {
            // 每个单词都要从根节点遍历
            Trie cur = root;
            for (char ch : word.toCharArray()) {
                // 如果存在这个字母
                if (cur.children.containsKey(ch)) {
                    // 指向下一个节点
                    cur = cur.children.get(ch);
                } else {
                    // 创建一个新节点存放当前字母
                    Trie newNode = new Trie();
                    // 连接
                    cur.children.put(ch,newNode);
                    // 指向下一个节点
                    cur = newNode;
                }
            }
            // 存储当前 单词
            cur.val = word;
            cur.isEnd = true;
        }
        // 遍历trim找最长单词
        String res = "";
        for (String word : words) {
            // 从根节点遍历
            Trie cur = root;
            if (word.length()>res.length() ||
                    (word.length()==res.length() && word.compareTo(res)<0)) {
                // 默认这个元素可以当做最长单词
                boolean isWord = true;
                // 遍历这个单词
                for (char c : word.toCharArray()) {
                    // 当前字符的节点
                    cur = cur.children.get(c);
                    // 如果没有结束标志
                    if (!cur.isEnd) {
                        isWord = false;
                        break;
                    }
                }
                // 如果没有跳出循环，则当前字符为最长字符串
                res = isWord ? word:res;
            }
        }
        return res;
    }
}

class Trie {
    public HashMap<Character,Trie> children = new HashMap<>();
    public boolean isEnd = false;
    public String val = null;
}
