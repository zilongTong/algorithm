/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: Server.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-06-12 03 : 23:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-06-12 03 : 23:47> <version>   <desc>
 */

package rpc.netty.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

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
        DatagramPacket packet = null;
        try {
            DatagramSocket socket = new DatagramSocket(8800);
            byte[] data = null;
            int count = 0;
            System.out.println("***服务器端启动，等待发送数据***");
            while (true) {
                data = new byte[1024];
                packet = new DatagramPacket(data, data.length);
                socket.receive(packet);
                Thread thread = new Thread(new UDPThread(socket, packet));
                thread.start();
                count++;
                System.out.println("服务器端被连接过的次数：" + count);
                InetAddress address = packet.getAddress();
                System.out.println("当前客户端的IP为：" + address.getHostAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
