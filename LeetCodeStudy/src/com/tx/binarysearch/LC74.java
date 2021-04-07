package com.tx.binarysearch;

public class LC74 {
    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            for (int num : nums) {
                if (num == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        System.out.println(matrix[0].length*matrix.length);
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length==0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row*col-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            // (x,y)->x * col + y
            // 对col计算得到二维索引
            int element = matrix[mid/col][mid%col];
            if (element == target) {
                return true;
            } else if (element < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
