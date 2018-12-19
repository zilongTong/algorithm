package org.tzl.lintcode;

/**
 * Created by leo on 2017/7/24.
 */
public class TwoSum {

    /*
 * @param numbers : An array of Integer
 * @param target : target = numbers[index1] + numbers[index2]
 * @return : [index1 + 1, index2 + 1] (index1 < index2)
 */
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        for (int i = 0; i < numbers.length; i++) {
            int j = i + 1;
            for (; j < numbers.length; j++) {
                int tem = numbers[i] + numbers[j];
                if (tem == target) {
                    return new int[] { i + 1, j + 1 };
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 7, 6, 8, 10 };
        int target = 9;
        twoSum(numbers, target);
    }
}
