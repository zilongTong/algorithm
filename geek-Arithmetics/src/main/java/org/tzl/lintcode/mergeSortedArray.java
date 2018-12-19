/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: mergeSortedArray.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-01-09 05 : 47:08
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-01-09 05 : 47:08> <version>   <desc>
 */

package org.tzl.lintcode;


import org.springframework.util.Assert;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class mergeSortedArray {

    public static void main(String[] args) {
            Solution(new int[]{1,2,3, 0,0},3,new int[]{1,6},2);

    }

    public static void Solution(int[] A, int m, int[] B, int n) {
        int pos = m + n - 1;
        int posA = m - 1;
        int posB = n - 1;

        while (posA >= 0 && posB >= 0) {
            if (A[posA] > B[posB]) {
                A[pos--] = A[posA--];
            } else {
                A[pos--] = B[posB--];
            }
        }
        while (posA >= 0) {
            A[pos--] = A[posA--];
        }
        while (posB >= 0) {
            A[pos--] = B[posB--];
        }
    }

}

