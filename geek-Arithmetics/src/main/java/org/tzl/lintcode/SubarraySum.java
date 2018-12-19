package org.tzl.lintcode;

import java.util.ArrayList;
import java.util.List;

public class SubarraySum {

    /*
    * @param nums: A list of integers
    * @return: A list of integers includes the index of the first number and the index of the last number
    */

    public static void main(String[] args) {
        subarraySum(new int[]{-3,1,9,3});
    }

    public static List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == 0) {
                indexs.add(i);
                indexs.add(i);
                return indexs;
            }
            for (int j = i + 1; j < nums.length - i; j++) {
                sum += nums[j];
                if (sum == 0) {
                    indexs.add(i);
                    indexs.add(j);
                    return indexs;
                }
            }
        }
        return indexs;
    }
}
