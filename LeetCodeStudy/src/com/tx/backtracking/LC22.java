package com.tx.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    public List<String> generateParenthesis(int n) {
        // 存放结果集
        ArrayList<String> res = new ArrayList<>();
        backTracking(res,n,0,0,"");
        return res;
    }
    // 结果集，n，左括号数量，右括号数量，当前添加的字符串
    public void backTracking(List<String> res, int n, int left, int right, String str) {
        // 如果当前左括号数量小于右括号数量，则跳出，因为不满足
        if (right > left) return;
        // 生成括号成功，添加
        if (left==n && right==n) {
            res.add(str);
            return;
        }
        // 还有左括号,添加左括号
        if (left < n) {
            backTracking(res,n,left+1,right,str+"(");
        }
        // 还有右括号，添加右括号
        if (right < left) {
            backTracking(res,n,left,right+1,str+")");
        }
    }
}
