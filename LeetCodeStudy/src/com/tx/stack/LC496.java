package com.tx.stack;

import java.util.HashMap;
import java.util.Stack;

//给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
//
// 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
//
public class LC496 {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            // 存放nums2
            Stack<Integer> stack = new Stack<>();
            // 存放结果集
            int[] result = new int[nums1.length];
            // 添加nums2到stack
            for (int num : nums2) {
                stack.push(num);
            }
            // 遍历nums1
            for (int i=0;i<nums1.length;i++) {
                // 临时栈，存放pop出来的元素
                Stack<Integer> tempStack = new Stack<>();
                // 标志位，是否找到
                boolean isFound = false;
                // 记录右边第一个最大的值
                int max = -1;
                // 遍历stack栈，找元素
                while (!stack.isEmpty() && !isFound) {
                    // 拿出nums2中的元素比较
                    int top = stack.pop();
                    if (top > nums1[i]) {
                        max = top;
                    } else if(top == nums1[i]) {
                        isFound = true;
                    }
                    // 将弹出的元素放到栈中
                    tempStack.push(top);
                }
                // 找出的max
                result[i] = max;
                // 把tempStack中的元素放回stack
                while (!tempStack.isEmpty()) {
                    stack.push(tempStack.pop());
                }
            }
            return result;
        }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        // 遍历nums2
        Stack<Integer> stack = new Stack<>();
        // 存放结果集
        int[] result = new int[nums1.length];
        // 存放每个元素的下一个最大元素
        HashMap<Integer, Integer> map = new HashMap<>();

        // 遍历nums2
        for (int num : nums2) {
            // 如果栈不为空，且栈顶元素小于当前元素，那么这个元素就是当前元素的下一个最大元素
            while (!stack.isEmpty() && num>stack.peek()) {
                // 将栈顶元素取出
                int temp = stack.pop();
                // 放入HashMap
                map.put(temp,num);
            }
            // 如果栈为空，则添加元素
            stack.push(num);
        }
        // 还有一部分元素在栈中，这些元素没有下一个最大元素，给他设置为-1
        while (!stack.isEmpty()) {
            map.put(stack.pop(),-1);
        }
        // 遍历HashMap给nums1找下一个最大元素
        for (int i=0;i<nums1.length;i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
