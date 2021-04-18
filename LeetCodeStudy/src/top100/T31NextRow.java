package top100;

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//

// 下一个排列
public class T31NextRow {
    public void nextPermutation(int[] nums) {
        // 从后往前，找相邻的升序元素，即A[i]<A[j]
        // i为倒数第二个元素
        int i = nums.length-2;
        // 找到倒序最小元素
        while (i>=0 && nums[i]>=nums[i+1]) {
            i--;
        }
        // 找倒序第一个比nums[i]大的元素
        if (i>=0) {
            int j = nums.length-1;
            while (j>=0 && nums[i]>=nums[j]) {
                j--;
            }
            swap(nums,i,j);
        }
        // 最后将i之后的元素升序排列
        reverse(nums,i+1);
    }

    public void swap(int[] nums,int left,int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void reverse(int[] nums,int start) {
        int left = start;
        int right = nums.length-1;
        while (left < right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}
