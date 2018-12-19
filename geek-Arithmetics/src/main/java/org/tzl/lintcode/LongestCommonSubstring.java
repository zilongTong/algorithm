package org.tzl.lintcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zilong on 2017/7/31.
 * 给出两个字符串，找到最长公共子串，并返回其长度。
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        new LongestCommonSubstring().longestCommonSubstring("www.lintcode.com code", "www.ninechapter.com code");
    }
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A==null || B==null||A==""||B=="") {
            return 0;
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < b.length; j++) {
                int hitL=0;
                if (a[i] == b[j]) {
                    for (int k=0;k<a.length-i;k++) {
                        try {
                            if (a[i + k] != b[j + k]) {
                                break;
                            }
                            hitL++;
                        }catch (ArrayIndexOutOfBoundsException e){

                        }
                    }
                }
                list.add(hitL);
            }

        }
//        Collections.sort(students, new Comparator<Students>() {
//
//            @Override
//            public int compare(Students o1, Students o2) {
//                int i = o1.getScore() - o2.getScore();
//                if(i == 0){
//                    return o1.getAge() - o2.getAge();
//                }
//                return i;
//            }
//        });
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1-o2>0){
                    return -1;
                }else if(o1-o2<0){
                    return 1;
                }
                return 0;
            }
        });
        return list.get(0);

    }
}
