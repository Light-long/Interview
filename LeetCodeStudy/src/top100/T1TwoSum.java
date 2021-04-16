package top100;

import java.util.HashMap;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

// 两数之和
public class T1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // 值nums[i]，索引i
        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历nums
        for (int i=0;i<nums.length;i++) {
            // 当前值 对应的 值在map中已经存在
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            // 如果target-nums[i]不存在在map中，就是没有找到，就把它放入map
            map.put(nums[i],i);
        }
        // 没有找到
        return new int[0];
    }
}
