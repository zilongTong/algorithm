package org.tzl.javaSort;

/**
 * Created by Ton on 2017/6/12.
 */
public class selectSort {


    /**
     * 简单选择排序
     * （1）基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    public selectSort() {
        int a[] = {1, 54, 6, 3, 78, 34, 12, 45};
        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            if (index != i) {
                swap(a, index, i);
            }

        }


        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void main(String[] args) {
        new selectSort();
    }
}
