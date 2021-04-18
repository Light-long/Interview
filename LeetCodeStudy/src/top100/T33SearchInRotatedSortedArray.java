package top100;

//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//

// 搜索旋转排序数组
public class T33SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        // 二分查找，nums总有一边是有序的
        int len = nums.length;
        if (nums == null || len==0) return -1;
        if (nums.length==1) return nums[0]==target? 0:-1;
        // binary search
        int left = 0;
        int right = len-1;
        while (left <= right) {
            int mid = left+(right-left)/2;
            if (target == nums[mid]) return mid;
            // 判断那面是有序的
            // 左边有序
            if (nums[0] <= nums[mid]) {
                // 判断target是否在这个区间
                if (target>=nums[0] && target<nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
                // 右边有序
            } else {
                if (target>nums[mid] && target<=nums[len-1]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
