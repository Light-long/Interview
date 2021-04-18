package top100;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 括号生成
// backtrack
public class T22GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        // 存放结果集
        List<String> res = new ArrayList<>();
        // 调用回溯算法
        backTracking(res,n,0,0,"");
        // 返回结果集
        return res;
    }
    // 结果集，n，左括号数量，右括号数量，子串
    public void backTracking(List<String> res, int n, int left, int right, String subset) {
        // 如果当前右括号数量大于左括号，不满足，跳出
        if (right > left) return;
        // 如果左括号数量=右括号数量=n，添加
        if (left==n && right==n) {
            res.add(subset);
            return;
        }
        // 还有左括号，添加左括号
        if (left < n) {
            backTracking(res,n,left+1,right,subset+"(");
        }
        // 还有右括号，添加右括号
        if (right < left) {
            backTracking(res,n,left,right+1,subset+")");
        }
    }
}
