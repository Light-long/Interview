package com.tx.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 添加空数组 []
        result.add(new ArrayList<>());
        // 回溯法，集合中有i个元素时
        for (int i=1;i<=nums.length;i++) {
            backTracking(nums,result,i,0,new ArrayList<>());
        }
        return result;
    }

    // 原数组|结果集|子集长度|集合索引|子集
    public static void backTracking(int[] nums,List<List<Integer>> result,
                             int length,int index,List<Integer> subset) {
        // 结束条件
        // 子集中的元素个数等于子集长度,把这个自己放入结果集
        if (subset.size() == length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // 遍历往子集中放元素
        for (int i=index;i<nums.length;i++) {
            subset.add(nums[i]);
            backTracking(nums,result,length,i+1,subset);
            // 把最后一个加入的元素删除，避免重复
            subset.remove(subset.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3};
        List<List<Integer>> subsets = subsets2(array);
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums,result,0,new ArrayList<>());
        return result;
    }

    public static void dfs(int[] nums,List<List<Integer>> result,int index,List<Integer> subset) {
        // 添加子数组
        result.add(new ArrayList<>(subset));
        if (nums.length == index) {
            return;
        }
        for (int i=index;i<nums.length;i++) {
            subset.add(nums[i]);
            dfs(nums,result,i+1,subset);
            subset.remove(subset.size()-1);
        }
    }
}
