package com.tx.recursion;

public class LC344 {
    public void reverseString1(char[] s) {
        if (s == null || s.length == 0) return;
        char tem = 'a';
        for (int i=0;i<s.length/2;i++) {
            tem = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = tem;
        }
    }

    // 递归
    public void reverseString2(char[] s) {
        recursion(s,0,s.length-1);
    }
    public void recursion(char[] s,int left,int right) {
        if (left >= right) {
            return;
        }
        recursion(s,left+1,right-1);
        char temp = s[left];
        s[left]= s[right];
        s[right] = temp;
    }
}
