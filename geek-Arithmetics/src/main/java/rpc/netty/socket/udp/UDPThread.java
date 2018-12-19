/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: UDPThread.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-06-12 02 : 43:39
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-06-12 02 : 43:39> <version>   <desc>
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
public class UDPThread implements Runnable {

    DatagramSocket socket = null;
    DatagramPacket packet = null;

    public UDPThread(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
    }

    @Override
    public void run() {
        String info = null;
        InetAddress address = null;
        int port = 8800;
        byte[] data = null;
        DatagramPacket packet1 = null;
        try {
            info = new String(packet.getData(), 0, packet.getLength());
            System.out.println("服务器，客户端：" + info);
            address = packet.getAddress();
            port = packet.getPort();
            data = "响应成功".getBytes();
            packet1 = new DatagramPacket(data, data.length, address, port);
            socket.send(packet1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
