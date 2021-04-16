package top100;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//

// 最长回文子串，动态规划
public class T5LongestPalindromicSubstrings {
    public String longestPalindrome(String s) {
        // 如果s的长度<2 ，直接返回s
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 定义初始最大长度
        int maxLen = 1;
        // 定义最大长度的起始位置
        int begin = 0;
        // dp[][]: s[i~j]是否为回文
        // dp[i][j] = dp[i+1][j-1] && s[i]==s[j]
        // 边界条件 : (j-1)-(i+1)+1<2 即 j-i<3可以确定为回文
        boolean[][] dp = new boolean[len][len];
        // 初始化，dp[i][i] = true,只有一个元素
        for (int i=0;i<len;i++) {
            dp[i][i] = true;
        }
        // 因为dp[i][j] = dp[i+1][j-1]，要想知道dp[i][j],首先要知道的左下角元素状态
        // 所以，先遍历列，在遍历行
        for (int j=1;j<len;j++) {
            for (int i=0;i<j;i++) {
                // 如果这两个元素不相等，false
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 如果剩余位置小于2，一定为回文
                    // 边界条件 : (j-1)-(i+1)+1<2 即 j-i<3可以确定为回文
                    if (j-i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                // 更新最大回文串
                if (dp[i][j] && j-i+1 > maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        // 截取回文串
        return s.substring(begin,begin+maxLen);
    }
}
