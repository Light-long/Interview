package com.tx.sort;

/**
 * 插入排序：平均O(n^2),最好O(n),稳定
 *
 * 把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的。
 * 从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。
 * 重复上述过程直到最后一个元素被插入有序子数组中。
 */
public class InsertSort {

    public static void insertSort(int[] array) {
        int len = array.length;
        // 默认0号索引位置的元素时有序的
        for (int i=1;i<len;i++) {
            // 记录当前元素
            int temp = array[i];
            // 记录当前索引
            int j = i;
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            while (j>0 && temp<array[j-1]) {
                array[j] = array[j-1];
                // 一直向左走
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {10,8,60,5,20,3,100,78,91};
        System.out.println("------InsertSort排序前------");
        for (int m : array) {
            System.out.print(m+" ");
        }
        System.out.println();
        insertSort(array);
        System.out.println("------InsertSort排序后------");
        for (int m : array) {
            System.out.print(m+" ");
        }
    }
}
