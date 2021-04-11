package com.tx.sort;

/**
 * 冒泡排序 ：O(n^2),稳定，最好O(n)
 *
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复步骤1~3，直到排序完成。
 */
public class Bubbling {
    public static void bubblingSort(int[] array) {
        // 标志位，是否交换了
        boolean flag = false;
        int len = array.length;
        for (int i=0;i<len-1;i++) {
            for (int j=i+1;j<len;j++) {
                if (array[i] > array[j]) {
                    swap(array,i,j);
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }

    private static void swap(int[] array,int left,int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    public static void main(String[] args) {
        int[] array = {10,8,60,5,20,3,100,78,91};
        System.out.println("------BubblingSort排序前------");
        for (int m : array) {
            System.out.print(m+" ");
        }
        System.out.println();
        bubblingSort(array);
        System.out.println("------BubblingSort排序后------");
        for (int m : array) {
            System.out.print(m+" ");
        }
    }
}
