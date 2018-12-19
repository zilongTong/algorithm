package org.tzl.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组和一个值，在原地删除与值相同的数字，返回新数组的长度.
 * 元素的顺序可以改变，并且对新的数组不会有影响。
 * Created by zilong on 2017/8/24.
 */
public class RemoveElement {

    public static void main(String[] args) {
        int a[]=new int[4];
        a[0]=9;
        a[1]=1;
        a[2]=9;
        a[3]=3;


        removeElement(a,9);
    }

    private static  int removeElement(int[] A, int elem) {
        // write your code here
        int pos = 0;
        for(int i = 0; i < A.length; i++){
            // 只拷贝非给定数字的元素
            if(A[i] != elem){
                A[pos] = A[i];
                pos++;
            }
        }
        return pos;
    }
}
