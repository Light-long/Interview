package top100;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//

// 寻找两个正序数组的中位数
public class T4MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = merge(nums1,nums2);
        return res.length%2==0 ?
                (res[(res.length-1)/2]+res[((res.length-1)/2)+1])/2.0
                :res[(res.length-1)/2];
    }
    // 合并两个数组
    public int[] merge(int[] nums1,int[] nums2) {
        int[] res = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while (i<nums1.length) {
            res[k++] = nums1[i++];
        }
        while (j<nums2.length) {
            res[k++] = nums2[j++];
        }
        return res;
    }
}
