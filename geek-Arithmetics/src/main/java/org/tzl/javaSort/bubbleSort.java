/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: bubbleSort.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-04-18 02 : 10:37
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-04-18 02 : 10:37> <version>   <desc>
 */

package org.tzl.javaSort;


import static org.tzl.javaSort.selectSort.swap;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class bubbleSort {

    public static void main(String[] args) {
        int[] a = {2, 1, 44, 4, 43, 21};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }

    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}