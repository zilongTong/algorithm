/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: MatchFileDemo.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-12-19 11 : 47:39
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-12-19 11 : 47:39> <version>   <desc>
 */

package org.tzl.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MatchFileDemo {


    public static void main(String[] args) {
        String target = "E:/files/target.txt";
        String source = "E:/files/source.txt";
        String result = "E:/files/result.txt";
        File t = createFile(target);
        File s = createFile(source);
        File r = createFile(result);
        doJob(t, s, r);
    }

    /**
     * 文件处理示例
     */
    public static File createFile(String url) {
        File f = new File(url);
        //判断目标文件所在的目录是否存在
        if (!f.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if (!f.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在目录失败！");
                //   return false;
            }
        }
        //创建目标文件
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void doJob(File t, File s, File r) {
        Map<String, String> map = new HashMap();
        BufferedWriter output = null;
        BufferedReader brt = null;
        BufferedReader brs = null;
        try {
            output = new BufferedWriter(new FileWriter(r));
            brt = new BufferedReader(new FileReader(t));//构造一个BufferedReader类来读取文件
            String tept = null;
            while ((tept = brt.readLine()) != null) {//使用readLine方法，一次读一行
                map.put(tept.substring(24, 44), tept);
            }
            brs = new BufferedReader(new FileReader(s));//构造一个BufferedReader类来读取文件
            String teps = null;
            while ((teps = brs.readLine()) != null) {//使用readLine方法，一次读一行
                String match = teps.substring(24, 44);
                if (map.containsKey(match)) {
                    output.write(teps + "\n");
                    System.out.println("匹配结果>>>>"+teps);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                brt.close();
                brs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
