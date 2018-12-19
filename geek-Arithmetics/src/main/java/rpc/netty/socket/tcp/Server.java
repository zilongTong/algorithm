/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: Server.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-06-12 10 : 49:12
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-06-12 10 : 49:12> <version>   <desc>
 */

package rpc.netty.socket.tcp;

import java.net.InetAddress;
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
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            int count = 0;
            System.out.println("***服务器即将启动，等待客户端的连接***");
            while (true) {
                socket = serverSocket.accept();
                Thread thread = new Thread(new ServerThread(socket));
                thread.start();
                count++;
                System.out.println("服务器连接次数：" + count);
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端ip：" + address.getHostAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
