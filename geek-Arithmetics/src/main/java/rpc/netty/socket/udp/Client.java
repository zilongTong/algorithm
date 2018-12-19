/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: Client.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-06-12 03 : 23:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-06-12 03 : 23:41> <version>   <desc>
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
public class Client {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port = 8800;
            //将字符串转换为字节数组
            byte[] data = "用户名：admin;密码：123".getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);

            byte[] data1 = new byte[1024];
            DatagramPacket packet1 = new DatagramPacket(data1, data1.length);
            socket.receive(packet1);
            String info = new String(data1, 0, packet1.getLength());
            System.out.println("客户端接收到服务器反馈：" + info);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
