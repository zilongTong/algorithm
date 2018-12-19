package org.tzl.lintcode;

import java.util.TreeMap;

/**
 * Created by zilong on 2017/7/26.
 */
public class Anagram {


    public  boolean anagram(String s, String t) {
        // write your code here
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        selectSort(c1);
        selectSort(c2);
        s = String.valueOf(c1);
        t = String.valueOf(c2);
        return s.equals(t);
    }

    private  void selectSort(char[] c) {
        int position;
        for (int i = 0; i < c.length; i++) {
            position = i;
            int j = i + 1;
            char tem = c[i];
            for (; j < c.length; j++) {
                if (tem > c[j]) {
                    tem = c[j];
                    position = j;
                }
            }
            c[position] = c[i];
            c[i] = tem;
        }
    }
}