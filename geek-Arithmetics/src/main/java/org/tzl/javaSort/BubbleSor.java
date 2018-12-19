package org.tzl.javaSort;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BubbleSor {


    public static void main(String[] args) {
        int[] a = {3, 4324, 3, 41, 233, 341, 341, 4123, 43, 4};
        solution(a);
        for (int i :
            a) {
            System.out.print("-" + i);
        }
    }

    public static void solution(int[] arr) {
        for (int i = 0; i <= arr.length - i; i++) {
            for (int j = 0; j <= arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {

                }
            }
        }
    }
}
