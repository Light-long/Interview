package com.tx.stack;

import java.util.Stack;

public class LC20 {
    public boolean isValid(String s) {
        if (s.length()%2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            // 如果是左括号，入栈
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' ) {
                stack.push(s.charAt(i));
            // 如果是右括号
            } else {
                if (stack.isEmpty()) return false;
                else {
                    if (s.charAt(i) == ')') {
                        if (stack.pop() != '(') return false;
                    } else if (s.charAt(i) == ']') {
                        if (stack.pop() != '[') return false;
                    } else if (s.charAt(i) == '}') {
                        if (stack.pop() != '{') return false;
                    }
                }
            }
        }
        // 栈为空，true
        return stack.isEmpty();
    }
}
