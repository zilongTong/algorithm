package org.tzl.lintcode;

/**
 * Created by zilong on 2017/7/31.
 * 给k个字符串，求出他们的最长公共前缀(LCP)
 * A:http://www.jianshu.com/p/63dcc0d7db75
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty())
                    return "";
            }

        }
        return prefix;
    }

}
