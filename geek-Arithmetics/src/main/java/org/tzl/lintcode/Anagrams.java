package org.tzl.lintcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zilong on 2017/7/28.
 * 给出一个字符串数组S，找到其中所有的乱序字符串(Anagram)。
 * 如果一个字符串是乱序字符串，那么他存在一个字母集合相同，
 * 但顺序不同的字符串也在S中。
 */
public class Anagrams {
    public static void main(String[] args) {
        anagrams(new String[] { "tea","and","ate","eat","den" });
    }

    public static List<String> anagrams(String[] strs) {
        // write your code here
        if (strs.length <= 0) {
            return Collections.emptyList();
        }
        List<String> hitList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            String ss = sort(s);

           if (map.containsValue(ss)) {
                if (list.contains(ss)) {
                    hitList.add(s);
                    list.add(ss);
                } else {
                    for (Map.Entry<Integer, String> entry : map.entrySet()) {
                        if (ss.equals(entry.getValue())) {
                            Integer key = entry.getKey();
                            hitList.add(strs[key]);
                            hitList.add(s);
                            list.add(ss);
                        }
                    }
                }

            }
            map.put(i, ss);
        }
        //        Map<String, Integer> tmap = new TreeMap<>();//接收的集合
        //        for (Map.Entry entry : map.entrySet()) {
        //            if (map.get(entry.getValue(
        //
        //            )) != null) {
        //                tmap.put(entry.getValue().toString(),
        //
        //                        tmap.get(entry.getValue()) + 1);
        //            } else {
        //                tmap.put(entry.getValue().toString(), 1);
        //
        //            }

        return hitList;
    }

    private static String sort(String s) {
        if (s == null) {
            return null;
        }
        char c[] = s.toCharArray();
        char tem = 0;
        for (int i = 1; i < c.length; i++) {
            int j = i - 1;
            tem = c[i];
            for (; j >= 0 && tem < c[j]; j--) {
                c[j + 1] = c[j];
            }
            c[j + 1] = tem;
        }
        return String.valueOf(c);
    }
}
