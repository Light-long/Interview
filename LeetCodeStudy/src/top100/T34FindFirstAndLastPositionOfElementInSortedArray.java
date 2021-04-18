package top100;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//

// 在排序数组中查找元素的第一个和最后一个位置
public class T34FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return new int[] {-1,-1};
        int fistIndex = findFirstIndex(nums,target);
        if (fistIndex == -1) return new int[] {-1,-1};
        int lastIndex = findLastIndex(nums,target);
        return new int[]{fistIndex,lastIndex};
    }

    public int findFirstIndex(int[] nums,int target) {
        int left = 0;
        int right = nums.length-1;
        // 跳出循环是，left = right
        while (left < right) {
            int mid = left+(right-left)/2;
            if (target < nums[mid]) {
                right = mid - 1;
                // 因为找的是第一个，所以，right = mid;
            } else if(target == nums[mid]) {
                right = mid;
            } else if (target > nums[mid]){
                left = mid+1;
            }
        }
        // 判断是否找到了
        if (nums[left] == target) return left;
        return -1;
    }

    public int findLastIndex(int[] nums,int target) {
        int left = 0;
        int right = nums.length-1;
        // 跳出循环是，left = right
        while (left < right) {
            // 看到两个设置left的，需要将
            int mid = (left+right+1)/2;
            if (target < nums[mid]) {
                right = mid - 1;
                // 因为找的是最后一个，所以，left = mid;
            } else if(target == nums[mid]) {
                left = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
