package com.tx.sort;

/**
 * 选择排序：最好O(n^2),最坏O(n^2),不稳定
 *
 * 在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 重复第二步，直到所有元素均排序完毕。
 */
public class SelectSort {
    public static void selectSort(int[] array) {
        int len = array.length;
        // 最小索引
        int min;
        for (int i=0;i<len-1;i++) {
            // 寻找最小索引
            min = i;
            for (int j=i+1;j<len;j++) {
                if (array[min] > array[j])
                    // 记录最小索引
                    min = j;
            }
            // 首元素即为最小元素，不用交换
            if (min != i) {
                swap(array,min,i);
            }
        }
    }

    // swap
    private static void swap(int[] array, int min, int i) {
        int temp = array[min];
        array[min] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10,8,60,5,20,3,100,78,91};
        System.out.println("------SelectSort排序前------");
        for (int m : array) {
            System.out.print(m+" ");
        }
        System.out.println();
        selectSort(array);
        System.out.println("------SelectSort排序后------");
        for (int m : array) {
            System.out.print(m+" ");
        }
    }
}
