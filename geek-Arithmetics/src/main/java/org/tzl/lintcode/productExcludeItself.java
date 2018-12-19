/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: productExcludeItself.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-01-11 11 : 15:42
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-01-11 11 : 15:42> <version>   <desc>
 */

package org.tzl.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <给定一个整数数组A。
 * 定义B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]， 计算B的时候请不要使用除法。>
 * 给出A=[1, 2, 3]，返回 B为[6, 3, 2]
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class productExcludeItself {

    public List<Long> solution(List<Integer> nums) {

        // write your code here

        List<Long> res = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            long product = 1;
            for (int j = 0; j < nums.size(); j++) {
                if (j != i) {
                    product *= nums.get(j);
                }
            }
            res.add(product);
        }
        return res;
    }
}

