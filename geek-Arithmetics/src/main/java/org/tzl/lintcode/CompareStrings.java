package org.tzl.lintcode;

import java.util.ArrayList;

/**
 * Created by zilong on 2017/7/27.
 * 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母
 */
public class CompareStrings {
    public static void main(String[] args) {
        new CompareStrings().compareStrings("ABCDEFG", "ACC");
    }

    public boolean compareStrings(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return false;
        }
        if (B.length() > A.length()) {
            return false;
        }
        char[] c1 = A.toCharArray();
        char[] c2 = B.toCharArray();
        char[] hit=new char[B.length()];
        int index=0;
        for (int i = 0; i < c2.length; i++) {
            for (int j = 0; j < c1.length; j++) {
                char b=c2[i];
                char c=c1[j];
                if (b == c) {
                    hit[index]=b;
                    c1[j]=0;
                    index++;
                    break;
                }
            }
        }
        insertSort(hit);
        insertSort(c2);
        A = String.valueOf(hit);
        B = String.valueOf(c2);
        System.out.println(B.equals(A));
        return B.equals(A);
        /*if (A == null || B == null) {
            return false;
        }
        if (B.length() > A.length()) {
            return false;
        }
        char[] c1 = A.toCharArray();
        char[] c2 = B.toCharArray();
        insertSort(c1);
        insertSort(c2);

        A = String.valueOf(c1);
        B = String.valueOf(c2);
        int index = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == c2[0]) {
                index = i;
            }
            break;
        }
        String QA = A.substring(index, B.length());
        return B.equals(QA);*/
    }

    private void insertSort(char[] c) {

        char tem = 0;
        //下标大于当前比较值，下标位右移一位，循环结束，比较值所在位置为j+1
        for (int i = 1; i < c.length; i++) {
            tem = c[i];
            int j = i - 1;
            for (; j >= 0 && tem < c[j]; j--) {
                c[j] = c[j + 1];
            }
            c[j + 1] = tem;
        }
    }

}
