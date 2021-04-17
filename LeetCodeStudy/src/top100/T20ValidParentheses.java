package top100;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。

//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//


import java.util.HashMap;
import java.util.Stack;

// 有效的括号
public class T20ValidParentheses {
    public boolean isValid1(String s) {
        // 括号数量为奇数个是，为false
        if (s == null || s.length()%2==1) return false;
        // 一个栈存放括号
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            // 取出每个字符
            char ch = s.charAt(i);
            // 如果是左括号，入栈
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                // 右括号，如果此时栈为空，则false
                if (stack.isEmpty()) return false;
                else {
                    // 判断当前括号是否与栈顶括号匹配
                    if (ch == ')') {
                        if (stack.peek() != '(')
                            return false;
                            // 如果匹配，把对应的左括号弹出栈
                        else stack.pop();
                    }
                    if (ch == ']') {
                        if (stack.peek() != '[')
                            return false;
                            // 如果匹配，把对应的左括号弹出栈
                        else stack.pop();
                    }
                    if (ch == '}') {
                        if (stack.peek() != '{')
                            return false;
                            // 如果匹配，把对应的左括号弹出栈
                        else stack.pop();
                    }
                }
            }
        }
        // 遍历完，如果栈为空，则为true
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        // 括号数量为奇数个是，为false
        if (s == null || s.length()%2==1) return false;
        // 一个栈存放括号
        Stack<Character> stack = new Stack<>();
        // 一个HashMap存放括号
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i=0;i<s.length();i++) {
            // 取出每个字符
            char ch = s.charAt(i);
            // 如果是右括号，判断栈是否为空，栈不为空，则false，
            // 栈顶元素与当前元素不匹配false
            // 匹配，弹出栈
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || map.get(ch) != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                // 如果是左括号，直接入栈
                stack.push(ch);
            }
        }
        // 遍历完，如果栈为空，则为true
        return stack.isEmpty();
    }
}
