package org.tzl.javaSort;

import static org.tzl.javaSort.BubbleSor.swap;

/**
 * Created by Ton on 2017/6/12.
 */
public class insertSort {

    public static void main(String[] args) {
        int[] arr = {3, 3231, 543, 3, 5, 4};
        solution(arr);
        for (int i : arr)
            System.out.print(i + "\t|\t");
    }

    /**
     * 1.直接插入排序w
     * （1）基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
     * 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
     * 也是排好顺序的。如此反复循环，直到全部排好顺序。
     */
    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j <= i && j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}