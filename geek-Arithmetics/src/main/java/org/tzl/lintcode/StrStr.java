package org.tzl.lintcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by zilong on 2017/7/28.
 * 对于一个给定的 source 字符串和一个 target 字符串，
 * 你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 */
public class StrStr {
    public static void main(String[] args) {
        strStr("","");
    }
    public static  int strStr(String source, String target) {
        // write your code here
        if(source==null||target==null){
            return -1;
        }
        char c1[] = source.toCharArray();
        char c2[] = target.toCharArray();
        Map<Integer, String> map = new HashMap<>();
        if("".equals(target)){
            return 0;
        }
        for (int i = 0; i < c1.length; i++) {
            if (c2[0] == c1[i]) {
                try {
                    map.put(i, source.substring(i, i+target.length()));
                } catch (Exception e) {
                }
            }
        }
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            if (entry.getValue().equals(target)) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
