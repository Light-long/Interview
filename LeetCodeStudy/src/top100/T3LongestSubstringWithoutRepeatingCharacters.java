package top100;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//

import java.util.HashMap;

// 无重复最长子串
public class T3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        // 当前字符：索引位置
        HashMap<Character, Integer> map = new HashMap<>();
        // sliding windows
        int left = 0;
        // 最大值
        int max = 0;
        // 遍历s
        for (int i=0;i<s.length();i++) {
            // 取出当前字符
            char temp = s.charAt(i);
            // 如果map中已经存在当前字符
            if (map.containsKey(temp)) {
                // 移动left到重复元素索引的后一位
                left = Math.max(left,map.get(temp)+1);
            }
            // 不存在当前字符,添加进map
            // 已经存在，更新索引
            map.put(temp,i);
            // 更新max
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
