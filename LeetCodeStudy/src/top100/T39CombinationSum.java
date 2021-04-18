package top100;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
//
//
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1：
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 组数总和
public class T39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        // 排序，可以减少判断
        Arrays.sort(candidates);
        dfs(res,candidates,target,0,combine);
        return res;
    }
    // target为组数之和，begin为开始的节点，combie为子集
    public void dfs(List<List<Integer>> res,int[] candidates,int target,int begin,List<Integer> combine) {
        // 每次加上某个数都会减小
        if (target == 0) {
            // 将当前子集放入结果集（避免引用传递）
            res.add(new ArrayList<>(combine));
            return;
        }
        // 遍历candidates
        for (int i=begin;i<candidates.length;i++) {
            // 判断如果target-candidates[i]<0就不进行后面的判断了，都比target大
            if (target - candidates[i] < 0 ) {
                return;
            }
            // 将当前元素加入子集
            combine.add(candidates[i]);
            // 将当前值加入子集,又因为可以重复加入，所以，i还是i
            dfs(res,candidates,target-candidates[i],i,combine);
            // 没回溯一遍都要删除最后一个元素
            combine.remove(combine.size()-1);
        }
    }
}
