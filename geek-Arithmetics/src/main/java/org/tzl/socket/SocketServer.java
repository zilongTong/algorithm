/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: SocketServer.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-05-11 04 : 29:08
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-05-11 04 : 29:08> <version>   <desc>
 */

package org.tzl.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SocketServer {

    public static void main(String args[]) {

        try {

            ServerSocket server = null;

            try {

                server = new ServerSocket(4700);

                //创建一个ServerSocket在端口4700监听客户请求

            } catch (Exception e) {

                System.out.println("can not listen to:" + e);

                //出错，打印出错信息

            }

            Socket socket = null;

            try {

                socket = server.accept();

                //使用accept()阻塞等待客户请求，有客户

                //请求到来则产生一个Socket对象，并继续执行

            } catch (Exception e) {

                System.out.println("Error." + e);

                //出错，打印出错信息

            }

            String line;

            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //由Socket对象得到输入流，并构造相应的BufferedReader对象

            PrintWriter os = new PrintWriter(socket.getOutputStream());

            //由Socket对象得到输出流，并构造PrintWriter对象

            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

            //由系统标准输入设备构造BufferedReader对象

            System.out.println("Client:" + is.readLine());

            //在标准输出上打印从客户端读入的字符串

            line = sin.readLine();

            //从标准输入读入一字符串

            while (!line.equals("bye")) {
                //如果该字符串为 "bye"，则停止循环
                os.println(line);
                //向客户端输出该字符串
                os.flush();
                //刷新输出流，使Client马上收到该字符串
                System.out.println("Server:" + line);
                //在系统标准输出上打印读入的字符串
                System.out.println("Client:" + is.readLine());
                //从Client读入一字符串，并打印到标准输出上
                line = sin.readLine();
                //从系统标准输入读入一字符串
            }
            //继续循环
            //关闭Socket输出流
            os.close();
            //关闭Socket输入流
            is.close();
            //关闭Socket
            socket.close();
            //关闭ServerSocket
            server.close();

        } catch (Exception e) {

            System.out.println("Error:" + e);

            //出错，打印出错信息

        }

    }

}
