package com.tx.sort;

/**
 * 快速排序：平均O(n*log^n),最坏O(n^2)，不稳定，空间复杂度O(log^n)
 *
 * 从数列中挑出一个元素，称为"基准"（pivot），
 * 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序
 */
public class QuickSort {

    public static void quickSort(int[] array,int left,int right) {
        if (left < right) {
            int partitionPivot = partition(array,left,right);
            quickSort(array,left,partitionPivot-1);
            quickSort(array,partitionPivot+1,right);
        }
    }

    /**
     * 分区
     * @param array 数组
     * @param left 左边索引
     * @param right 右边索引
     * @return 返回基准pivot索引
     */
    public static int partition(int[] array,int left,int right) {
        // 默认第一个元素为基准元素
        int pivot = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            // 先从右往左找第一个小于pivot的元素
            while (i<j && array[j] > pivot) j--;
            // 从左往右找第一个大于pivot的元素
            while (i<j && array[i] < pivot) i++;
            swap(array,i,j);
        }
        // 将基准元素与array[left]元素swap，基准归位
        // todo
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10,8,60,5,20,3,100,78,91,2,88};
        System.out.println("------QuickSort排序前------");
        for (int m : array) {
            System.out.print(m+" ");
        }
        System.out.println();
        quickSort(array,0,array.length-1);
        System.out.println("------QuickSort排序后------");
        for (int m : array) {
            System.out.print(m+" ");
        }
    }
}
