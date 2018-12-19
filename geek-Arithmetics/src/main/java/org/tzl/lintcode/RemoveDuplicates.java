/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: RemoveDuplicates.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-12-28 02 : 18:26
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-12-28 02 : 18:26> <version>   <desc>
 */

package org.tzl.lintcode;

import javax.swing.plaf.SpinnerUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。
 * 不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。
 */
public class RemoveDuplicates {


    public static void main(String[] args) {
        System.out.println(Solution(new int[]{-10,0,1,2,3}));
    }

    public static int Solution(int[] nums) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(nums[i]);
            }
        }
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                nums[i] = list.get(i);
            }
        }
        return list.size();
    }


}
