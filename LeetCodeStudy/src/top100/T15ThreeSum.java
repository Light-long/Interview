package top100;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和
// sort + two points
public class T15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 结果集
        List<List<Integer>> res = new ArrayList<>();
        // bottom case
        if (nums == null || nums.length<=2) return res;
        // 对nums排序
        Arrays.sort(nums);
        // 遍历nums
        for (int first = 0;first<nums.length-1;first++) {
            // 找到第一个不重复的元素,和他的前一个元素比较
            if (first>0 && nums[first]==nums[first-1]) continue;
            // two points
            int third = nums.length-1;
            // target+两个指针指向位置的值=0
            int target = -nums[first];
            for (int second=first+1;second<third;second++) {
                // 找到第一个不重复的元素
                if (second>first+1 && nums[second]==nums[second-1]) continue;
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second<third && nums[second]+nums[third]>target) {
                    third--;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) break;
                // 判断和是否为0
                if (nums[second]+nums[third] == target) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[first],nums[second],nums[third]));
                    res.add(list);
                }
            }
        }
        return res;
    }
}
