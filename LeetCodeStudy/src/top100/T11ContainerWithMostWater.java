package top100;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。
// 示例 1：
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//

// 盛最多水的容器
// two points
public class T11ContainerWithMostWater {
    // 每次以双指针为左右边界（也就是「数组」的左右边界）计算出的容量中的最大值。
    public int maxArea(int[] height) {
        // 初始化最大容量为0
        int max = 0;
        // two points
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            // 左右边界的最小值*right-left
            int curArea = Math.min(height[left],height[right])*(right-left);
            // 更新最大值
            max = Math.max(max,curArea);
            // 判断左右边界大小，小的往中间靠近
            if (height[left] <= height[right]) left++;
            else right--;
        }
        return max;
    }
}
