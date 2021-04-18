package top100;

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 示例 1：
//
//
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
//

// 最长有效括号
public class T32LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int maxAns = 0;
        // dp:到i索引的最长符合标准字符串
        int[] dp = new int[len];
        for (int i=1;i<len;i++) {
            // 只有右括号才需要判断，左括号一定不为终止，所以为0
            if (s.charAt(i) == ')') {
                // 如果i-1位置为（，则为2+dp[i-2]
                if (s.charAt(i-1) == '(') {
                    // 如果i=1,dp[1] = 2+dp[-1],dp[-1]=0
                    dp[i] = 2 + (i>=2 ? dp[i-2] : 0);
                    // i减去内部括号dp[i-1]后，再-1如果是（,就能继续加
                } else if (i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='(') {
                    // 还要加上，之前连在一起的，但要判断，防止出现-1的情况
                    dp[i] = 2+dp[i-1]+(i-dp[i-1]-2>=0 ? dp[i-dp[i-1]-2]:0);
                }
            }
            maxAns = Math.max(maxAns,dp[i]);
        }
        return maxAns;
    }
}
