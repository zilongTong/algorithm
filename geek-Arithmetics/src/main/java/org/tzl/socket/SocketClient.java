/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: SocketClient.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-05-11 04 : 24:49
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-05-11 04 : 24:49> <version>   <desc>
 */

package org.tzl.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SocketClient {

    public static void main(String args[]) {

        try {

            Socket socket = new Socket("192.168.10.180", 4700);

            //向本机的4700端口发出客户请求

            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

            //由系统标准输入设备构造BufferedReader对象
            PrintWriter os = new PrintWriter(socket.getOutputStream());

            //由Socket对象得到输出流，并构造PrintWriter对象

            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //由Socket对象得到输入流，并构造相应的BufferedReader对象

            String readline;
            //从系统标准输入读入一字符串
            readline = sin.readLine();
            while (!readline.equals("bye")) {
                //若从标准输入读入的字符串为 "bye"则停止循环
                os.println(readline);
                //将从系统标准输入读入的字符串输出到Server
                os.flush();
                //刷新输出流，使Server马上收到该字符串
                System.out.println("Client:" + readline);
                //在系统标准输出上打印读入的字符串
                System.out.println("Server:" + is.readLine());
                //从Server读入一字符串，并打印到标准输出上
                //从系统标准输入读入一字符串
                readline = sin.readLine();
            }
            //继续循环

            os.close(); //关闭Socket输出流

            is.close(); //关闭Socket输入流

            socket.close(); //关闭Socket

        } catch (Exception e) {
            //出错，则打印出错信息
            System.out.println("Error" + e);

        }

    }

}

