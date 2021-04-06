package com.tx.hashtable;

//给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
// 请找出在 t 中被添加的字母。
public class LC389 {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) return t.charAt(0);
        int[] hashtable = new int[26];
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            int temp = (int) ch-97;
            hashtable[temp] = hashtable[temp] - 1;
        }
        for (int i=0;i<t.length();i++) {
            char ch = t.charAt(i);
            int temp = (int) ch-97;
            hashtable[temp] = hashtable[temp] + 1;
        }
        // 遍历hashtable
        for (int i=0;i<hashtable.length;i++) {
            if (hashtable[i] == 1) {
                return (char)(i+97);
            }
        }
        return 'a';
    }
}
