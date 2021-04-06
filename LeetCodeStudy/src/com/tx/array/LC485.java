package com.tx.array;

//给定一个二进制数组， 计算其中最大连续 1 的个数。
//
//
//
// 示例：
//
//
//输入：[1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
//
//
//
//
// 提示：
//
//
// 输入的数组只包含 0 和 1 。
// 输入数组的长度是正整数，且不超过 10,000。
//
// Related Topics 数组

public class LC485 {
    /**
     * @param nums
     * @return result
     * 遍历一遍nums数组
     * 用count计数
     * 用result保存最大的count数
     */
    public static int maxOneNum(int[] nums) {
        // 每次1的次数
        int count = 0;
        // 保留最大的count
        int result = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                // 记录最大的count
                result = Math.max(result, count);
                // 次数清零
                count = 0;
            }
        }
        // 最后再比较一次，返回最大的count
        return Math.max(result,count);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1,1,0};
        System.out.println(maxOneNum(nums));
    }
}
