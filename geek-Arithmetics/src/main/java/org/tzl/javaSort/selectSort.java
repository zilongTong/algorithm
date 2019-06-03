package org.tzl.javaSort;

/**
 * Created by Ton on 2017/6/12.
 */
public class selectSort {

    public static void main(String[] args) {
        int[] arr = {3, 3231, 543, 3, 5, 4};
        solution(arr);
        for (int i : arr)
            System.out.print(i + "\t|\t");
    }

    /**
     * 简单选择排序
     * （1）基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            swap(arr, index, i);
        }
    }


    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
