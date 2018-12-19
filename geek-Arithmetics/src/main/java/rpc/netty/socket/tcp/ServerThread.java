/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: ServerThread.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-06-12 11 : 17:18
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-06-12 11 : 17:18> <version>   <desc>
 */

package rpc.netty.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
public class ServerThread implements Runnable {
    /**
     * 本线程相关的socket
     */
    Socket socket = null;


    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is, "utf-8");
            br = new BufferedReader(isr);
            String data = null;
            while ((data = br.readLine()) != null) {
                System.out.println("服务器接收客户端信息：" + data);
            }
            socket.shutdownInput();
            os=socket.getOutputStream();
            pw=new PrintWriter(os);
            pw.write("服务器响应成功");
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭资源即相关socket
            try {
                if(pw!=null)
                    pw.close();
                if(os!=null)
                    os.close();
                if(br!=null)
                    br.close();
                if(isr!=null)
                    isr.close();
                if(is!=null)
                    is.close();
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
