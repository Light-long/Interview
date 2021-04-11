package com.tx.sort;

/**
 * 归并排序：平均O(n*log^n),最坏O(n*log^n)，稳定，空间复杂度O(n)
 *
 * 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 重复步骤3直到某一指针到达序列尾
 * 将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class MergeSort {

    public static void mergeSort(int[] array,int low,int high) {
        if (low < high) {
            int mid = low+(high-low)/2;
            // 左子数组
            mergeSort(array,low,mid);
            // 右子数组
            mergeSort(array,mid+1,high);
            // 合并子数组
            merge(array,low,mid,high);
        }
    }

    public static void merge(int[] array,int low,int mid,int high) {
        // 创建一个临时数组存放排序结果
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        // 临时数组索引
        int k = 0;
        while (i<=mid && j<=high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        // 把左边剩下的元素放入temp
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // 把右边剩下的元素放入temp
        while (j <= high) {
            temp[k++] = array[j++];
        }
        // 把temp中的元素赋给array
        /**
         *
         * for (int x=0;x<temp.length;x++) {
         *             array[low+x] = temp[x];
         *         }
         */
        if (temp.length >= 0) System.arraycopy(temp, 0, array, low, temp.length);
    }

    public static void main(String[] args) {
        int[] array = {10,8,60,5,20,3,100,78,91,2,88};
        System.out.println("------MergeSort排序前------");
        for (int m : array) {
            System.out.print(m+" ");
        }
        System.out.println();
        mergeSort(array,0,array.length-1);
        System.out.println("------MergeSort排序后------");
        for (int m : array) {
            System.out.print(m+" ");
        }
    }
}
